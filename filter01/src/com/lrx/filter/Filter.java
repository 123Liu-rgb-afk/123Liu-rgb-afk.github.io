package com.lrx.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class Filter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init被调用");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter被调用");

        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object username = session.getAttribute("username");
        System.out.println("doFilter servletRequest="+ servletRequest);
        if(username != null) {
            filterChain.doFilter(servletRequest, servletResponse);

        }else {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
        }


    }

    @Override
    public void destroy() {

        System.out.println("destrop被调用");
    }
}
