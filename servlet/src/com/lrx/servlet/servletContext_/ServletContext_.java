package com.lrx.servlet.servletContext_;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class ServletContext_ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取web.xml的context-parameter
        ServletContext servletContext = getServletContext();
        String company = servletContext.getInitParameter("company");
        System.out.println("company= " + company);
        //获取工程路径
        String contextPath = servletContext.getContextPath();
        System.out.println("工程路径= " + contextPath);
        //项目发布后，在硬盘上面的绝对路径
        String realPath = servletContext.getRealPath("/");
        System.out.println("绝对路径= " + realPath);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
