package com.lrx.ajax.servlet;

import com.google.gson.Gson;
import com.lrx.ajax.javabean.User;
import com.lrx.ajax.service.UserServlice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class CheckUname extends HttpServlet {
    private UserServlice userServlice = new UserServlice();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("CheckUname 被调用");

        String uname = req.getParameter("uname");
        System.out.println("unama=" + uname);

        //从数据库里面获得数据
        resp.setContentType("text/html;charset=utf-8");
        User user = userServlice.getUserByName(uname);
        System.out.println("user 对象= " + user);
        if(user != null) {
            Gson gson = new Gson();
            String strUser = gson.toJson(user);
            resp.getWriter().write(strUser);

        }else{
            resp.getWriter().write("");
        }
//        resp.setContentType("text/html;charset=utf-8");
//        if("king".equals(uname)) {
//            User king = new User(100, "king", "444", "king@suhu.com");
//            String strKing = new Gson().toJson(king);
//            resp.getWriter().write(strKing);
//
//        }else{
//            resp.getWriter().write("");
//
//        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
