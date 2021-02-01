/**
 * Copyright 2020 Alien
   Created on 31/07/20207:32:40 AM  by ayman Elgharabawy
 */
package com.alien.robot.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
 
// TODO: Auto-generated Javadoc
/**
 * The Class SpringContex is helper class to get the bean by classname
 * I use it because jbolt api is not springified
 */
@Component
public class SpringContext implements ApplicationContextAware {
     
    /** The context. */
    private static ApplicationContext context;
     
    /**
     * Returns the Spring managed bean instance of the given class type if it exists.
     * Returns null otherwise.
     *
     * @param <T> the generic type
     * @param beanClass the bean class
     * @return the bean
     */
    public static <T extends Object> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
     
    /**
     * Sets the application context.
     *
     * @param context the new application context
     * @throws BeansException the beans exception
     */
    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
         
        // store ApplicationContext reference to access required beans later on
        SpringContext.context = context;
    }
}