package com.ldyg.springframework.beans.factory.support;

import com.ldyg.springframework.beans.factory.BeanFactory;
import com.ldyg.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegister implements BeanFactory {
    @Override
    public Object getBean(String beanName) {
        Object singletonBean = getSingletonBean(beanName);
        if (singletonBean != null) {
            return singletonBean;
        }
        BeanDefinition beanDefinition = createBeanDenifition(beanName);
        return createBean(beanName, beanDefinition, null);
    }

    @Override
    public Object getBean(String beanName,Object...args) {
        Object singletonBean = getSingletonBean(beanName);
        if (singletonBean != null) {
            return singletonBean;
        }
        BeanDefinition beanDefinition = createBeanDenifition(beanName);
        return createBean(beanName, beanDefinition, args);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

    protected abstract BeanDefinition createBeanDenifition(String beanName);
}
