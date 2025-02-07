package com.lrx.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class UpdataCookie extends HttpServlet {
    //修改指定的cookie
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("updataCookei");
        Cookie emali = CookieUtils.ReadCookieByName("emali", req.getCookies());
        if(emali != null) {
            emali.setValue("222222");
            System.out.println(emali.getName() + " " + emali.getValue());
        }else {
            System.out.println("没找到");
        }

        if(emali != null) {
            resp.addCookie(emali);
        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("修改成功");
        writer.flush();
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
