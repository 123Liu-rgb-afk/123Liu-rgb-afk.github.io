package com.lrx.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lrx
 * {@code @date} 2025/3/10 下午1:17
 */
@Controller
public class CompulterHander {
    @RequestMapping(value = "/computer")
    public String compulterHander(String brand,String price,String nums){
        System.out.println("brand:"+brand + " price:"+price + " nums:"+nums);

        return "success";

    }
}
