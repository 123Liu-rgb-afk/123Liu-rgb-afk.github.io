package com.lrx.servlet.homework;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class PayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String money = req.getParameter("money");
        System.out.println(money);
        int i = Integer.parseInt(money);
        ServletContext servletContext = req.getServletContext();
        if(i > 100) {
            resp.sendRedirect(servletContext.getContextPath() + "/payOk.html");
        }else {
            resp.sendRedirect(servletContext.getContextPath() + "/pay.html");

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
