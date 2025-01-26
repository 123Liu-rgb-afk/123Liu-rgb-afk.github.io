package com.lrx.servelt; /**
 * @author 刘瑞玺
 * @version 1.0
 */

import com.lrx.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class CalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String strNum1 = request.getParameter("num1");
        String strNum2 = request.getParameter("num2");
        int num1 = WebUtils.parseInt(strNum1,0);
        int num2 = WebUtils.parseInt(strNum2,0);

        int sum = num2 + num1;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<h1>" + num1 + "+" +  num2 + "=" + sum + "<h1>");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
