package com.lrx.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class LrxServletRequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("LrxServletRequestListener 监听" + servletRequestEvent.getServletRequest() + " 被销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        System.out.println("LrxServletRequestListener 监听" + servletRequestEvent.getServletRequest() + " 被创建");
        System.out.println("访问的IP" + servletRequest.getRemoteAddr());
        System.out.println("访问的资源" + ((HttpServletRequest)servletRequest).getRequestURL());
    }
}
