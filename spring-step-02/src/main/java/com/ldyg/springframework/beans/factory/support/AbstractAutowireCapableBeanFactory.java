package com.ldyg.springframework.beans.factory.support;

import com.ldyg.BeansException;
import com.ldyg.springframework.beans.factory.config.BeanDefinition;

/**
 * 这个类用于实现创建对象的实例
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object obj;
        try {
            obj = beanDefinition.getBean().newInstance();
        }  catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        // 将获取的bean对象放入单例bean容器里面去
        beanRegister(beanName, obj);
        return obj;
    }
}
