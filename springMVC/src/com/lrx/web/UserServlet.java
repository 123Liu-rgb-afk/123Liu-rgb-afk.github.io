package com.lrx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lrx
 * {@code @date} 2025/3/10 上午10:25
 */
@Controller
public class UserServlet {

    //编写方法，响应用户请求
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

}
