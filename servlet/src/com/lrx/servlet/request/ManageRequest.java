package com.lrx.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class ManageRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String role = (String) req.getAttribute("role");

        //方案1 :解决乱码
        // resp.setContentType("text/html;charset=utf-8");
        //方案二:设置服务器端的编码为utf-8
        resp.setCharacterEncoding("utf-8");
        //设置浏览器的编码为utf-8
        resp.setHeader("Content-type","text/html;charset=utf-8");

        PrintWriter writer = resp.getWriter();
        writer.print("用户名 =" + username);
        writer.print("role = " + role);

        writer.flush();
        writer.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
