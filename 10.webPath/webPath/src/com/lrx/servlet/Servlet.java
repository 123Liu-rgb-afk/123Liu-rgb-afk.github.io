package com.lrx.servlet; /**
 * @author 刘瑞玺
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //System.out.println("servlet 转发");
        //request.getRequestDispatcher("/views/user/user.html").forward(request,response);
        System.out.println("servlet 重定向");
        //写法1：response.sendRedirect("/webPath/views/user/user.html");
        //写法2：response.sendRedirect("http://localhost:8888/webPath/views/user/user.html");
        //写法3：response.sendRedirect("views/user/user.html");
        String contextPath = getServletContext().getContextPath();
        response.sendRedirect(contextPath + "/views/user/user.html");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
