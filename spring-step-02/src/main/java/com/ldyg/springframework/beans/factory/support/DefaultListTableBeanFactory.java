package com.ldyg.springframework.beans.factory.support;

import com.ldyg.BeansException;
import com.ldyg.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultListTableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
    // 存储bean定义的map
    Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("xxxx");
        }
        return beanDefinition;
    }

    @Override
    public void beanDefinitionRegistry(String beanName, BeanDefinition definition) {
        beanDefinitionMap.put(beanName,definition);
    }
}
