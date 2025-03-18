package com.lrx.web.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lrx
 * {@code @date} 2025/3/18 下午12:50
 */
@Controller
public class FurnHandler {

    @RequestMapping(value = "/hi")
    public String hi() {
        System.out.println("FurnHandler hi()");
        return "success";
    }
    @RequestMapping(value = "/hello")
    public String hello() {
        System.out.println("FurnHandler hello()");
        return "success";
    }
}
