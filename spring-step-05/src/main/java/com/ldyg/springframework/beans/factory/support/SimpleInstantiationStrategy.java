package com.ldyg.springframework.beans.factory.support;

import com.ldyg.BeansException;
import com.ldyg.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiation(BeanDefinition definition, Object[] args, Constructor constructor, String beanName) {
        Class bean = definition.getBeanClass();
        try {
            if (constructor != null) {
                return bean.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                return bean.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + bean.getName() + "]", e);
        }
    }
}
