package com.ldyg.springframework.beans.factory.support;

import com.ldyg.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
