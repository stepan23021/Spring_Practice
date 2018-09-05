package com.example.dmitrii.spring_practice;

import com.example.dmitrii.spring_practice.rockets.MyCustomAnnotation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.example.dmitrii.spring_practice.ansi_colors.Colors.ANSI_RED;
import static com.example.dmitrii.spring_practice.ansi_colors.Colors.ANSI_RESET;

/**
 * @author Dmitrii Stepcenco
 * @created 04 September 2018
 **/

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println(ANSI_RED + "I AM ALIVE" + ANSI_RESET);
        String[] names = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);
            String originalClassName = beanDefinition.getBeanClassName();
            if(originalClassName==null){

            }else{
            try {
                Class<?> originalClass = Class.forName(originalClassName);
                Method[] methods = originalClass.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                        System.out.println(name);
                        System.out.println(ANSI_RED + "АННОТАЦИЯ НАШЛАСЬ" + ANSI_RESET);
                        Object bean = configurableListableBeanFactory.getBean(name);
                        Method currentMethod = bean.getClass().getMethod(method.getName());
                        currentMethod.invoke(bean);
                    }
                }
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            }
        }
    }
}
