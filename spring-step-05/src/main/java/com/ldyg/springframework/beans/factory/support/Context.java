package com.ldyg.springframework.beans.factory.support;

import com.ldyg.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public class Context {
    public InstantiationStrategy strategy;
    public Context(InstantiationStrategy strategy) {
        this.strategy = strategy;
    }

    public Object getStrategy(BeanDefinition definition, String beanName, Constructor constructor, Object...args) {
        return strategy.instantiation(definition, args, constructor, beanName);
    }
}
