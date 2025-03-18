package com.lrx.web.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lrx
 * {@code @date} 2025/3/18 下午9:55
 */
@ControllerAdvice
public class MyGlobalException {
    @ExceptionHandler({ClassCastException.class, NumberFormatException.class})
    public String localException(Exception ex, HttpServletRequest request){
        System.out.println("全局异常信息是= " + ex.getMessage());
        request.setAttribute("reason", ex.getMessage());
//如何将异常的信息带到下一个页面.
    return "exception_mes";
    }

}
