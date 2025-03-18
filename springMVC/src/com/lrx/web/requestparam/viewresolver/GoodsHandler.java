package com.lrx.web.requestparam.viewresolver;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lrx
 * {@code @date} 2025/3/11 下午9:29
 */
@RequestMapping(value = "/goods")
@Component
public class GoodsHandler {

    @RequestMapping(value = "/buy")
    public String buy() {
        System.out.println("=======buy()=====");
        return "view";
    }


    @RequestMapping(value = "/order")

    public String order() {
        System.out.println("=======order()=====");
//这里直接指定 转发到哪个页面
return "forward:/WEB-INF/pages/my_view.jsp";
//重定向, 如果是重定向，就不能重定向到 /WEB-INF 目录中
        //return "redirect:/login.jsp";

    }

}
