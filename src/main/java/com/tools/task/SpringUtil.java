package com.tools.task;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Administrator on 14-3-3.
 */
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException{
        applicationContext = arg0;
    }

    public  static Object getObject(String id){
        Object object = null;
        object = applicationContext.getBean(id);
        return  object;

    }
}
