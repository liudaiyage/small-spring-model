package com.ldyg.springframework.beans.factory.support;

import com.ldyg.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    // 存储bean实例的map
    Map<String, Object> singlentonMaps = new ConcurrentHashMap<>();

    @Override
    public void beanRegister(String beanName, Object bean) {
        singlentonMaps.put(beanName, bean);
    }

    @Override
    public Object getSingletonBean(String beanName) {
        return singlentonMaps.get(beanName);
    }
}
