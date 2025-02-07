package com.lrx.cookie; /**
 * @author 刘瑞玺
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doGet 被调用");
        Cookie cookie = new Cookie("username", "lrx");
        Cookie emali = new Cookie("emali", "123");

        emali.setPath(request.getContextPath());
        cookie.setPath(request.getContextPath() + "/aaa");

        response.addCookie(cookie);
        response.addCookie(emali);

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Cookie创建成功<h1>");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
