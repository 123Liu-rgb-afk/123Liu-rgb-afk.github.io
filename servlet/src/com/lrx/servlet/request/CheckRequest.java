package com.lrx.servlet.request;

import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class CheckRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        if("tom".equals(username)) {
            req.setAttribute("role","管理员");
        }else {
            req.setAttribute("role","普通用户");
        }


        RequestDispatcher requestDispatcher
                = req.getRequestDispatcher("/mangeRequest");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
