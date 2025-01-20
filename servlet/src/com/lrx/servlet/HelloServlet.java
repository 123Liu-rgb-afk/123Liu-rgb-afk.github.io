package com.lrx.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 * 开发一个servlet 需要 Servlet 接口
 * 实现接口的方法有5个
 */
public class HelloServlet implements Servlet {

    /**
     * 初始化 servlet
     * 当创建HelloServlet时 ，会调用 init 方法
     * 只会被调用一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        System.out.println("init() 被调用");
    }

    /**
     * 放回ServletConfig ，也就是返回 Servlet 的配置
     * @return
     */

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 1.servlet 方法是处理浏览器的请求（get/post）
     * 2.浏览器每请求一次就调用一次
     * 3.当Tomcat 调用该方法时， 会把浏览器的请求 的数据对象封装成实现了ServletRequest 接口的 request对象
     * 4.通过servletResquest 对象，可以得到用户的提交的数据
     * 5.servletResponse 对象可以放回数据给Tomcat - 给浏览器
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest,
                        ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("hi HelloServlet~");
        System.out.println("当前线程：" + Thread.currentThread().getId());


        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        if(method.equals("post")) {
            System.out.println(method);
        }else if (method.equals("get")) {
            System.out.println(method);
        }
    }

    /**
     * 放回 servlet 信息 ，使用较少
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁 servlet时，tomcat调用
     */
    @Override
    public void destroy() {

    }
}
