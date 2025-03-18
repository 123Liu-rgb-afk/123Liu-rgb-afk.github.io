package com.lrx.web.requestparam;

import com.lrx.web.requestparam.entity.Master;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lrx
 * {@code @date} 2025/3/11 下午8:53
 */
@RequestMapping(value = "/vote")
@Component
public class VoteHandler {

    @RequestMapping(value = "/vote1")

    public String test01(@RequestParam(value = "name" ,required = false)
                             String username) {
        System.out.println("得到的 username= " + username);
//返回到一个结果
        return "success";
    }

    @RequestMapping(value = "/vote02")
    public String test02( @RequestHeader("Accept-Encoding") String ae,
                          @RequestHeader("Host") String host) {
        System.out.println("Accept-Encoding =" + ae);
        System.out.println("Host =" + host);
//返回到一个结果
        return "success";
    }
    @RequestMapping(value = "/vote03")
    public String test03(Master master) {
        System.out.println("主人信息= " + master);
//返回结果
        return "success";
    }
}
