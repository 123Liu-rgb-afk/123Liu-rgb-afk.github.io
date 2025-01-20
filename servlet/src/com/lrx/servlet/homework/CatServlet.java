package com.lrx.servlet.homework;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author 刘瑞玺
 *
 * @version 1.0
 */
public class CatServlet implements Servlet {

    private int count = 0;
    private int countGET = 0;
    private int countPOST = 0;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        count++;
        System.out.println(count);

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        System.out.println(method);
        if(method.equals("GET"))
        {
            System.out.println("get的次数= " + (++countGET));
        }else if(method.equals("POST")) {
            System.out.println("Post的次数= " + (++countPOST));
        }



    }
    public void doGet() {
        System.out.println("doGet 被调用");
    }
    public void doPost() {
        System.out.println("doPost 被调用");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
