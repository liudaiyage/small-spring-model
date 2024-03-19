package com.ldyg.springframework.beans.factory.config;

/**
 * 用于注册并获取bean
 */
public interface SingletonBeanRegistry {

    void beanRegister(String beanName, Object bean);

    Object getSingletonBean(String beanName);
}
