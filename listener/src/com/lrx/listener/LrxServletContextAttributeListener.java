package com.lrx.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
/*
该类实现了 LrxServletContextAttributeListener 也就是监听类
启动web项目时，会创建一个 ServletContextEvent ，调用相关的事件处理方法
，同时会把事件对象发送给监听器
 */
public class LrxServletContextAttributeListener implements ServletContextAttributeListener {

        @Override
        public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
                System.out.println("LrxServletContextAttributeListener 监听"
                        + servletContextAttributeEvent.getName() +"="+ servletContextAttributeEvent.getValue() + "被创建...");
        }

        @Override
        public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
                System.out.println("LrxServletContextAttributeListener 监听"
                        + servletContextAttributeEvent.getName() + "="+ servletContextAttributeEvent.getValue() +"被删除...");
        }

        @Override
        public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
                System.out.println("LrxServletContextAttributeListener 监听"
                        + servletContextAttributeEvent.getName() +"="+ servletContextAttributeEvent.getValue() + "被替换...");
        }
}
