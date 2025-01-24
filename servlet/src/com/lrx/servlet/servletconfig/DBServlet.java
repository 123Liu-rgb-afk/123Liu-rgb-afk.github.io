package com.lrx.servlet.servletconfig;

import javax.servlet.ServletConfig;
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
public class DBServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {


        /*获得ServeltContext 有两种方式
         * 解决容器的并发，可以使用ConcurrentHashMap
         * public ServletContext getServletContext() {
         *         return this.getServletConfig().getServletContext();
         *     }
         */
        System.out.println("init= " + config);

        //tomcat 把servletConfig 对象 赋给 GenericServlet 的 config属性 ,这样才能获取servletconfig
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取web.xml文件中配置的姓名和密码
        ServletConfig servletConfig = getServletConfig();
        String username = servletConfig.getInitParameter("username");
        String pwd = servletConfig.getInitParameter("pwd");
        System.out.println("username= " + username);
        System.out.println("pwd= " + pwd);
        System.out.println(servletConfig);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
