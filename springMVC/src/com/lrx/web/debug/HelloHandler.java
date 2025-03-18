package com.lrx.web.debug;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lrx
 * {@code @date} 2025/3/18 下午10:27
 */

@Controller
public class HelloHandler {
    /**
     * 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/debug/springmvc")
    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ok");
        modelAndView.addObject("name", "老韩");
        return modelAndView;
    }
}
