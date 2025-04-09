package com.lrx.springbootusersys.controller;

import com.lrx.springbootusersys.bean.Admin;
import com.lrx.springbootusersys.bean.User;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

/**
 * @author lrx
 * {@code @date} 2025/4/9 下午2:48
 */
@Controller
@Slf4j
public class AdminController {

    @PostMapping("login")
    public String login(Admin admin, HttpSession session, Model model) {
        if(StringUtils.hasLength(admin.getName()) && admin.getPassword().equalsIgnoreCase("666")){
            session.setAttribute("admin", admin);
            return "redirect:/manage.html";

        }else{
            model.addAttribute("msg", "账号/密码错误");
            return "login";
        }

    }

    @GetMapping("/manage.html")
    public String manage(Model model, HttpSession session) {

            log.info("执行 mainPage()");
            ArrayList<User> users = new ArrayList<>();
            users.add(new User(1, "关羽~", "666666", 20, "gy@sohu.com"));
            users.add(new User(2, "张飞", "666666", 30, "zf@sohu.com"));
            users.add(new User(3, "赵云", "666666", 22, "zy@sohu.com"));
            users.add(new User(4, "马超", "666666", 28, "mc@sohu.com"));
            users.add(new User(5, "黄忠", "666666", 50, "hz@sohu.com"));
            model.addAttribute("users", users);
            return "manage";

//        Object admin = session.getAttribute("admin");
//        if(admin != null){
//            ArrayList<User> users = new ArrayList<>();
//            users.add(new User(1, "关羽~", "666666", 20, "gy@sohu.com"));
//            users.add(new User(2, "张飞", "666666", 30, "zf@sohu.com"));
//            users.add(new User(3, "赵云", "666666", 22, "zy@sohu.com"));
//            users.add(new User(4, "马超", "666666", 28, "mc@sohu.com"));
//            users.add(new User(5, "黄忠", "666666", 50, "hz@sohu.com"));
//            model.addAttribute("users", users);
//            return "manage";
//        }else {
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }

    }
}
