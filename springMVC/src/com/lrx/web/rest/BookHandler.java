package com.lrx.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author lrx
 * {@code @date} 2025/3/11 下午8:12
 */
@RequestMapping(value = "/user")
@Controller
public class BookHandler {
    //查询[GET]
    @GetMapping(value = "/book/{id}")
    public String getBook(@PathVariable("id") String id) {
        System.out.println("查询书籍 id=" + id );
        return "success";
    }
    //添加[POST]
    @PostMapping(value = "/addbook")
    public String addBook(String bookName) {
        System.out.println("添加书籍 bookName== " + bookName);
        return "success";
    }
    //删除[DELETE]
    @DeleteMapping(value = "/deleteBook/{id}")
    public String delBook(@PathVariable("id") String id) {
        System.out.println("删除书籍 id= " + id);
//return "success"; [如果 这样返 回会报错 JSPs only permit GET POST orHEAD]
        return "redirect:/user/success"; //重定向到一个没有指定 method 的 Handler 方法
    }
    //修改[PUT]
    @PutMapping(value = "/book/{id}")
    public String updateBook(@PathVariable("id") String id) {
        System.out.println("修改书籍 id=" + id);
        return "redirect:/user/success"; //重定向到一个没有指定 method 的 Handler 方法
    }
    @RequestMapping(value = "/success")
    public String successGenecal() {
        return "success"; //由该方法 转发到 success.jsp 页面
    }
}
