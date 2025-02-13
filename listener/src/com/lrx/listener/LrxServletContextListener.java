package com.lrx.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
/*
该类实现了ServletContextListener 也就是监听类
启动web项目时，会创建一个 ServletContextEvent ，调用相关的事件处理方法
，同时会把事件对象发送给监听器
 */
public class LrxServletContextListener implements ServletContextListener {
        @Override
        public void contextInitialized(ServletContextEvent servletContextEvent) {
                System.out.println("LrxServletContextListener 监听" + servletContextEvent.getServletContext() + " 被创建...");
        }

        @Override
        public void contextDestroyed(ServletContextEvent servletContextEvent) {
                System.out.println("LrxServletContextListener 监听" + servletContextEvent.getServletContext() + " 被销毁...");

        }
}
