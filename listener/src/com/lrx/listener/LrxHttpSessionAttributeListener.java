package com.lrx.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
/*
该类实现了 LrxServletContextAttributeListener 也就是监听类
启动web项目时，会创建一个 ServletContextEvent ，调用相关的事件处理方法
，同时会把事件对象发送给监听器
 */
public class LrxHttpSessionAttributeListener implements HttpSessionAttributeListener {
        @Override
        public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {

                System.out.println("LrxHttpSessionAttributeListener 监听" + httpSessionBindingEvent.getName() + "=" + httpSessionBindingEvent.getValue() + " 被创建");
        }

        @Override
        public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
                System.out.println("LrxHttpSessionAttributeListener 监听" + httpSessionBindingEvent.getName() + "=" + httpSessionBindingEvent.getValue() + " 被删除");

        }

        @Override
        public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
                System.out.println("LrxHttpSessionAttributeListener 监听" + httpSessionBindingEvent.getName() + "=" + httpSessionBindingEvent.getValue() + " 被修改");

        }
}



