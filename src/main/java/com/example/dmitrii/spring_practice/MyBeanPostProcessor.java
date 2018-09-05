package com.example.dmitrii.spring_practice;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Dmitrii Stepcenco
 * @created 03 September 2018
 **/

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean + " --postProcessBeforeInitialization()");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean + "postProcessAfterInitialization()");

        return bean;
    }
}
