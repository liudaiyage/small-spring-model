package com.ldyg.springframework.beans.factory.config;

public interface SingletonBeanRegietry {

    Object getSingletonBean(String beanName);

    void registerSingletonBean(String beanName, Object bean);
}
