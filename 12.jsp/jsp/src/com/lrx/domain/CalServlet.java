package com.lrx.domain;

import com.lrx.domain.utils.WebUitl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class CalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("calServlet");

        int num1 = WebUitl.parseInt(req.getParameter("num1"), 0);
        int num2 = WebUitl.parseInt(req.getParameter("num2"), 0);
        String oper = req.getParameter("oper");
        double res = 0;
        if(oper.equals("+")) {
            res = num1 + num2;
        }else if(oper.equals("-")){
            res = num1 - num2;

        }else if(oper.equals("*")){
            res = num1 * num2;

        }else if(oper.equals("/")){
            res = (double) num1 / num2;

        }else {

            System.out.println(oper + "不正确");
        }

        String format = String.format("%s %s %s = %s", num1,oper,num2,res);


        req.setAttribute("res",format);

        req.getRequestDispatcher("/cal/calRes.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
