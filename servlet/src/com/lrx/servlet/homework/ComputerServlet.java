package com.lrx.servlet.homework;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class ComputerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ComputerServlet");

        String user_Agent = req.getHeader("user-Agent");
        String resStr = "\\((.*)\\;";
        Pattern compile = Pattern.compile(resStr);
        Matcher matcher = compile.matcher(user_Agent);
        matcher.find();
        String group = matcher.group(1);
        String[] split = group.split(";");
        System.out.println(split[0]);
        System.out.println(split[1].trim());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
