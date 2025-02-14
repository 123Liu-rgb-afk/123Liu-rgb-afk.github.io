package com.lrx.filter;

import javax.servlet.*;
import javax.servlet.Filter;
import java.io.IOException;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class CommentFilter implements Filter {
    private String[] forbiddenword;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        String sensitive = filterConfig.getInitParameter("sensitive");
        forbiddenword = sensitive.split(",");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding("utf-8");
        String comment = servletRequest.getParameter("comment");
        System.out.println(comment);
        for (String s : forbiddenword) {

            if(comment.contains(s)) {
                servletRequest.setAttribute("errorInfo","你输入有违禁词");
                servletRequest.getRequestDispatcher("/comment.jsp").forward(servletRequest,servletResponse);
                return;
            }

        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
