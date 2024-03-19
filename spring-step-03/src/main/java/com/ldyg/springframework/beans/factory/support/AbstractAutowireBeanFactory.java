package com.ldyg.springframework.beans.factory.support;

import com.ldyg.BaseException;
import com.ldyg.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object obj;
        try {
            obj = createBeanInstance(beanName, beanDefinition, args);
        } catch (Exception e) {
            throw new BaseException("Instantiation of bean failed", e);
        }
        registerSingletonBean(beanName, obj);
        return obj;
    }

    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructorToUser = null;
        Class bean = beanDefinition.getBean();
        Constructor[] declaredConstructors = bean.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            if (null != args && declaredConstructor.getGenericParameterTypes().length == args.length) {
                constructorToUser = declaredConstructor;
                break;
            }
        }
//        Context context = new Context(new CglibStrategy());
        Context context = new Context(new JdkStrategy());
        return context.getStrategy(beanDefinition, beanName, constructorToUser, args);
    }

}
