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
public class ReadCookieByName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ReadCookieByName");
        Cookie email = CookieUtils.ReadCookieByName("emali", req.getCookies());
        if(email != null ){
            System.out.println(email.getName() + email.getValue());
        }else {
            System.out.println("没找到");
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("读取成功");
        writer.flush();
        writer.close();
    }
}
