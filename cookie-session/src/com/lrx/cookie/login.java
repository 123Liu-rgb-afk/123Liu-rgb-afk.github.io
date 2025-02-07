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
public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie login = CookieUtils.ReadCookieByName("login", cookies);
        String username = "";
        if(login != null) {
           username = login.getValue();
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/html\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>登录</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>用户登录</h1>\n" +
                "<form action=\"/cs/homeWork01\" method=\"post\">\n" +
                "    用户名:<input type=\"text\" value=\"" + username + "\"name=\"username\"></br>\n" +
                "    密 码: <input type=\"password\" name=\"pwd\"></br>\n" +
                "    <input type=\"submit\" value=\"登录\">\n" +
                "\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
