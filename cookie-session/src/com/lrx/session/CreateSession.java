package com.lrx.session; /**
 * @author 刘瑞玺
 * @version 1.0
 */

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("doGet 被调用");

        HttpSession session = request.getSession();
        String id = session.getId();
        System.out.println("CreateSession " + id);
        session.setAttribute("liu","zhang");

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Session创建成功<h1>");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
