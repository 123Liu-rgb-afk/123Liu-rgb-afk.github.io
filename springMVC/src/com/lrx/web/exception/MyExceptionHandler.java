package com.lrx.web.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lrx
 * {@code @date} 2025/3/18 下午9:07
 */
@Controller
public class MyExceptionHandler {
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class, AgeException.class})
    public String localException(Exception ex, HttpServletRequest request){
        System.out.println("异常信息是~" + ex.getMessage());
//如何将异常的信息带到下一个页面.
        request.setAttribute("reason", ex.getMessage());
        return "exception_mes";
    }
    @RequestMapping(value="/testException01")
    public String test01(Integer num){
        int i = 9/num;
        return "success";
    }
    @RequestMapping(value="/testGlobalException")
    public String global(){
//老韩解读
//1. 模拟 NumberFormatException
//2. 在老韩定义的局部异常中，没有对 NumberFormatException
//3. 所有就会去找全局异常处理
        int num = Integer.parseInt("hello");
        return "success";
    }

    @RequestMapping(value="/testException02")
    public String test02(){
        throw new AgeException("年龄需要在 1-120 之间");
    }

    @RequestMapping(value="/testException03")
    public String test03(){
        int[] arr = new int[]{3,9,10,190};
        System.out.println(arr[90]);
        return "success";
    }
}
