package com.ldyg.springframework.beans.factory.support;

import com.ldyg.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiation(BeanDefinition definition, Object[] args, Constructor constructor, String beanName);
}
