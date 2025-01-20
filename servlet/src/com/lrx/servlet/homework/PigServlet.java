package com.lrx.servlet.homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
@WebServlet(urlPatterns = {"/pig1","/pig2"}, loadOnStartup = 1)
public class PigServlet extends HttpServlet {
    private int countGET = 0;
    private int countPost = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问的浏览器IP= " + req.getRemoteAddr());
        System.out.println("doGet 被调用,次数= " + (++countGET));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("访问的浏览器IP= " + req.getRemoteAddr());
        System.out.println("doPost 被调用,次数= " + (++countPost));
    }
}
