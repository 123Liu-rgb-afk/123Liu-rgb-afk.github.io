package com.lrx.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class LrxHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setMaxInactiveInterval(20);
        System.out.println("LrxHttpSessionListene 监听" + httpSessionEvent.getSession().getId() + "被创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("LrxHttpSessionListene 监听" + httpSessionEvent.getSession().getId() + "被销毁");

    }
}
