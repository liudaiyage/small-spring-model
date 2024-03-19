package com.ldyg.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.ldyg.BeansException;
import com.ldyg.springframework.beans.PropertyValue;
import com.ldyg.springframework.beans.PropertyValues;
import com.ldyg.springframework.beans.factory.config.BeanDefinition;
import com.ldyg.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object obj;
        try {
            obj = createBeanInstance(beanName, beanDefinition, args);
            // 填充bean属性
            fillFieldProperty(beanName, beanDefinition, obj);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        registerSingleton(beanName, obj);
        return obj;
    }

    private void fillFieldProperty(String beanName, BeanDefinition beanDefinition, Object obj) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            if (propertyValues != null) {

                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    String name = propertyValue.getName();
                    Object value = propertyValue.getValue();
                    if (value instanceof BeanReference) {
                        BeanReference reference = (BeanReference) value;
                        String bean = reference.getBeanName();
                        value = getBean(bean);
                    }
                    BeanUtil.setFieldValue(obj, name, value);
                }
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Constructor constructorToUser = null;
        Class bean = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = bean.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            if (null != args && declaredConstructor.getGenericParameterTypes().length == args.length) {
                constructorToUser = declaredConstructor;
                break;
            }
        }
        Context context = new Context(new CglibSubclassingInstantiationStrategy());
//        Context context = new Context(new SimpleInstantiationStrategy());
        return context.getStrategy(beanDefinition, beanName, constructorToUser, args);
    }

}
