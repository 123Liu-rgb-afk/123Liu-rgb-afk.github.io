package com.lrx.servlet.annotation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
//<init-param>
//            <param-name></param-name>
//            <param-value></param-value>
//        </init-param>
@WebServlet(urlPatterns = {"*.action","/ok1/*","/ok2"},initParams = @WebInitParam(name = "xx",value = "yy"))
public class OKServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("注解方式 init()方式被调用");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("注解 doGet 被调用");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("注解 doPost 被调用");

    }
}
