package com.lrx.servlet.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class DogServlet extends HttpServlet {

    private int countGET = 0;
    private int countPost = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet 被调用,次数= " + (++countGET));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost 被调用,次数= " + (++countPost));
    }
}
