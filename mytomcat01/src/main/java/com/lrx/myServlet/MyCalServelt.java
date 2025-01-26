package com.lrx.myServlet;

import com.lrx.http.MyHttpServletRequest;
import com.lrx.http.MyHttpServletRespond;
import com.lrx.utils.WebUtils;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class MyCalServelt extends MyHttpServlet {

    public MyCalServelt() {
    }

    @Override
    public void doGet(MyHttpServletRequest request, MyHttpServletRespond respond) {
        String strNum1 = request.getParameter("num1");
        String strNum2 = request.getParameter("num2");
        int num1 = WebUtils.parseInt(strNum1,0);
        int num2 = WebUtils.parseInt(strNum2,0);

        int sum = num2 + num1;

        OutputStream outputStream = respond.getOutputStream();
        String resp = respond.respHead + "<h1>" + num1 + "+" +  num2 + "=" + sum + "<h1>";
        try {
            outputStream.write(resp.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(MyHttpServletRequest request, MyHttpServletRespond respond) {

        doGet(request,respond);
    }

    @Override
    public void init() throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
