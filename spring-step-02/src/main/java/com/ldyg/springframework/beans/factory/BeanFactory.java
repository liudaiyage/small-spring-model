package com.ldyg.springframework.beans.factory;


/**
 * 用于创建bean方法
 */
public interface BeanFactory {

    Object getBean(String beanName);
}
