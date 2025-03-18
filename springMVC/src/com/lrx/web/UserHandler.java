package com.lrx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lrx
 * {@code @date} 2025/3/10 下午12:13
 */
@RequestMapping(value = "/user")
@Controller
public class UserHandler {
    @RequestMapping(value = "/buy",method = RequestMethod.POST)
    public String buy() {
        System.out.println("购买商品");
        return "success";
    }

   // @RequestMapping(value = "/find",params = "bookId", method = RequestMethod.GET)
    @GetMapping(value = "/find")
    public String search(String bookId) {
        System.out.println("查询书籍 bookId= " + bookId);
        return "success";
    }
    @RequestMapping(value = "/im/**")
    public String im() {
        System.out.println("发送消息");
        return "success";
    }

    @RequestMapping(value = "/reg/{username}/{userid}")
    public String register(@PathVariable("username") String name,
                           @PathVariable("userid") String id){
        System.out.println("接收到参数--" + "username= " + name + "--" + "usreid= " + id);
        return "success";
    }
}
