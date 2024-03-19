package com.ldyg.springframework.beans.factory.config;

public interface SingletonBeanRegietry {

    Object getSingleton(String beanName);

    void registerSingleton(String beanName, Object bean);
}
