package com.night.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }



    private static void assertApplicationContext() {
        if (SpringContextUtil.applicationContext == null) {
            throw new RuntimeException("applicaitonContext属性为null!");
        }
    }

    private static ApplicationContext getApplicationContext() {
        assertApplicationContext();
        return applicationContext;
    }

    public static <T> T getBean(String beanName) {
        assertApplicationContext();
        try {
            return (T) applicationContext.getBean(beanName);
        } catch (NoSuchBeanDefinitionException e){}
        return null;
    }

    public static <T> T getBean(Class<T> requiredType) {
        assertApplicationContext();
        try {
            return applicationContext.getBean(requiredType);
        } catch (NoSuchBeanDefinitionException e){}
        return null;
    }
}
