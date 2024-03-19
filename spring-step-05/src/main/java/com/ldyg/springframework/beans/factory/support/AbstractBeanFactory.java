package com.ldyg.springframework.beans.factory.support;


import com.ldyg.springframework.beans.BeansException;
import com.ldyg.springframework.beans.factory.BeanFactory;
import com.ldyg.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
//    @Override
//    public Object getBean(String beanName) {
//        Object singletonBean = getSingleton(beanName);
//        if (singletonBean != null) {
//            return singletonBean;
//        }
//        BeanDefinition beanDefinition = createBeanDenifition(beanName);
//        return createBean(beanName, beanDefinition, null);
//    }
//
//    @Override
//    public Object getBean(String beanName,Object...args) {
//        Object singletonBean = getSingleton(beanName);
//        if (singletonBean != null) {
//            return singletonBean;
//        }
//        BeanDefinition beanDefinition = createBeanDenifition(beanName);
//        return createBean(beanName, beanDefinition, args);
//    }

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }

    protected <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

    protected abstract BeanDefinition getBeanDefinition(String beanName);
}
