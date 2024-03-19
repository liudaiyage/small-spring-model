package com.ldyg.springframework.beans.factory.support;

import com.ldyg.springframework.beans.factory.config.BeanDefinition;
import com.ldyg.BaseException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultListTableBeanDefinition extends AbstractAutowireBeanFactory implements BeanDefinitionRegister{
    Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    protected BeanDefinition createBeanDenifition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BaseException("bean定义为null");
        }
        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
