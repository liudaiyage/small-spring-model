package com.ldyg.springframework.beans.factory.config;

public class BeanDefinition {

    public BeanDefinition(Class bean) {
        this.bean = bean;
    }


    private Class bean;


    public Class getBean() {
        return bean;
    }

    public void setBean(Class bean) {
        this.bean = bean;
    }
}
