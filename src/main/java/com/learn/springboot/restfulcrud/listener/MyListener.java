package com.learn.springboot.restfulcrud.listener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context initialized ... web应用启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context destroyed ... web项目销毁");
    }
}
