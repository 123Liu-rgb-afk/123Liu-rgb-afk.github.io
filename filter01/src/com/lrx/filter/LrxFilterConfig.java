package com.lrx.filter;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class LrxFilterConfig implements Filter {
    private String ip;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LrxFilterConfig init被调用");
        String filterName = filterConfig.getFilterName();
        ip = filterConfig.getInitParameter("ip");
        ServletContext servletContext = filterConfig.getServletContext();
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            System.out.println("name = " + initParameterNames.nextElement());
        }


        System.out.println("filterName = " + filterName);
        System.out.println("ip = " + ip);
        System.out.println("servletConfig = " + servletContext);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
        String remoteAddr = servletRequest1.getRemoteAddr();
        if(remoteAddr.contains(ip)) {
            System.out.println("网段拦截...");
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
