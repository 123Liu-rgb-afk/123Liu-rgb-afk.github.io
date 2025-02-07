package com.lrx.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class HomeWork01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        System.out.println(username);
        System.out.println(pwd);


        if(username.equals("刘") && pwd.equals("123")){
            writer.write("登录成功");
        }else {
            writer.write("登录失败");
        }
        Cookie cookie = new Cookie("login",username);
        cookie.setMaxAge(6000);
        if(cookie != null) {
            resp.addCookie(cookie);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
