package com.lrx.myServlet;

import com.lrx.http.MyHttpServletRequest;
import com.lrx.http.MyHttpServletRespond;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public abstract class MyHttpServlet implements Servlet{
    public void service(MyHttpServletRequest request, MyHttpServletRespond respond) {
        if("GET".equalsIgnoreCase(request.getMethod())){
            this.doGet(request,respond);
        }else if("POST".equalsIgnoreCase(request.getMethod())) {
            this.doPost(request,respond);
        }
    }
    public abstract void doGet(MyHttpServletRequest request, MyHttpServletRespond respond);
    public abstract void doPost(MyHttpServletRequest request, MyHttpServletRespond respond);
}
