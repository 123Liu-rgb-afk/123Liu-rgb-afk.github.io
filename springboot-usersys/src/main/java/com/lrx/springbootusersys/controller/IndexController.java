package com.lrx.springbootusersys.controller;

import com.lrx.springbootusersys.bean.Admin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author lrx
 * {@code @date} 2025/4/7 下午10:43
 */
@Controller
public class IndexController {

    @GetMapping(value = {"/","/login"})
    public String login() {
        return "login";
    }

}
