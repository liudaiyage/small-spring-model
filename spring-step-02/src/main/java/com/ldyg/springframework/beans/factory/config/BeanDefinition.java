package com.ldyg.springframework.beans.factory.config;

/**
 * bean定义
 */
public class BeanDefinition {

    private Class bean;

    public BeanDefinition(Class bean) {
        this.bean = bean;
    }

    public Class getBean() {
        return bean;
    }

    public void setBean(Class bean) {
        this.bean = bean;
    }
}
