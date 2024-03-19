package com.ldyg.springframework.beans.factory.support;

import com.ldyg.springframework.beans.factory.config.SingletonBeanRegietry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegietry {

    Map<String, Object> stringObjectMap = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return stringObjectMap.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object bean) {
        stringObjectMap.put(beanName, bean);
    }
}
