package com.lrx.myServlet;

import com.lrx.http.MyHttpServletRequest;
import com.lrx.http.MyHttpServletRespond;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public interface Servlet {

    void init() throws ServletException;

    void service(MyHttpServletRequest request, MyHttpServletRespond respond) throws  IOException;


    void destroy();

}
