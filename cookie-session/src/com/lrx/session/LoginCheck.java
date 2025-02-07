package com.lrx.session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class LoginCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginCheck");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        if(pwd.equals("666666")) {
            HttpSession session = req.getSession();
            session.setAttribute("name",username);
            resp.sendRedirect("/cs/manageServlet");
        }else{
            resp.sendRedirect("/cs/error.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
