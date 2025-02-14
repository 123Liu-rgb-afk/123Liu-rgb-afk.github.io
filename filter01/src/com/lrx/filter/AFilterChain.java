package com.lrx.filter;

import javax.servlet.*;
import javax.servlet.Filter;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class AFilterChain implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("AFilterChain doFilter 被调用 , 前置代码");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("AFilterChain 后置代码");

    }

    @Override
    public void destroy() {

    }
}
