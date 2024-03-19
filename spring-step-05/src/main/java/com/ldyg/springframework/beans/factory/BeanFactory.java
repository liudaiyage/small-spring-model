package com.ldyg.springframework.beans.factory;

public interface BeanFactory {

    Object getBean(String beanName);

    Object getBean(String beanName, Object...args);
}
