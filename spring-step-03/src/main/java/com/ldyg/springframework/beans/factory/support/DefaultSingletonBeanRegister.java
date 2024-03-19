package com.ldyg.springframework.beans.factory.support;

import com.ldyg.springframework.beans.factory.config.SingletonBeanRegietry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegister implements SingletonBeanRegietry {

    Map<String, Object> stringObjectMap = new ConcurrentHashMap<>();

    @Override
    public Object getSingletonBean(String beanName) {
        return stringObjectMap.get(beanName);
    }

    @Override
    public void registerSingletonBean(String beanName, Object bean) {
        stringObjectMap.put(beanName, bean);
    }
}
