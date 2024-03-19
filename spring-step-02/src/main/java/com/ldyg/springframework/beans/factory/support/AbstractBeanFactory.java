package com.ldyg.springframework.beans.factory.support;

import com.ldyg.springframework.beans.factory.BeanFactory;
import com.ldyg.springframework.beans.factory.config.BeanDefinition;

/**
 * 模板方法，定义一个抽象类，用于创建和获取bean
 *
 * 这里有个注意点，就是两个抽象方法会分别给不同的类进行实现
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) {
        // 先从内存里面拿bean对象，没有拿到就去创建bean对象
        Object bean = this.getSingletonBean(beanName);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        // 在创建bean的过程中需要将bean对象放入到缓存中去
        return createBean(beanName, beanDefinition);
    }

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);

    protected abstract BeanDefinition getBeanDefinition(String beanName);

}
