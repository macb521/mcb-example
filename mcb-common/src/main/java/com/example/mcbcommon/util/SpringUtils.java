package com.example.mcbcommon.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author chunbo.ma.o
 * @since 2023/11/27
 */
@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    /**
     * 获取当前的环境配置，无配置返回null
     *
     * @return 当前的环境配置
     */
    public static String[] getActiveProfiles() {
        return applicationContext.getEnvironment().getActiveProfiles();
    }

    /**
     * 获取当前的环境配置，当有多个环境配置时，只获取第一个
     *
     * @return 当前的环境配置
     */
    public static String getActiveProfile() {
        final String[] activeProfiles = getActiveProfiles();
        return !isEmpty(activeProfiles) ? activeProfiles[0] : null;
    }

    public static boolean isEmpty(Object[] objects) {
        return objects == null || (objects.length == 0);
    }

    /**
     * @param name name
     * @return Class 注册对象的类型
     */
    public static Class<?> getType(String name) throws NoSuchBeanDefinitionException {
        return applicationContext.getType(name);

    }

    /**
     * getBean
     *
     * @param name   name
     * @param tClass tClass
     * @param <T>    t
     * @return T
     */
    public static <T> T getBean(String name, Class<T> tClass) {
        return applicationContext.getBean(name, tClass);
    }

    /**
     * getBean
     *
     * @param name name
     * @param <T>  T
     * @return T
     */
    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

}
