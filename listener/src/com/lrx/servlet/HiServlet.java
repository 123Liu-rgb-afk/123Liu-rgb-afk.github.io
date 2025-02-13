package com.lrx.servlet; /**
 * @author 刘瑞玺
 * @version 1.0
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HiServlet", value = "/HiServlet")
public class HiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("name","csdn");
        servletContext.setAttribute("name","博客");
        servletContext.removeAttribute("name");

        HttpSession session = request.getSession();

        session.setAttribute("age","100");
        session.setAttribute("age","10");
        session.removeAttribute("age");
        System.out.println("测试完毕...");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
