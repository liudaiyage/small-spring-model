package com.ldyg.springframework.beans.factory.support;

import com.ldyg.springframework.beans.factory.config.BeanDefinition;
import com.ldyg.BaseException;

import java.lang.reflect.Constructor;

public class JdkStrategy implements InstantiationStrategy{
    @Override
    public Object instantiation(BeanDefinition definition, Object[] args, Constructor constructor, String beanName) {
        Class bean = definition.getBean();
        try {
            if (constructor != null) {
                return bean.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                return bean.getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            throw new BaseException("Failed to instantiate [" + bean.getName() + "]", e);
        }
    }
}
