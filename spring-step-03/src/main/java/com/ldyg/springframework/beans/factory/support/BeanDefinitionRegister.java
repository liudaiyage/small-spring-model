package com.ldyg.springframework.beans.factory.support;

import com.ldyg.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegister {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
