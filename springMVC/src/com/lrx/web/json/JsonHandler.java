package com.lrx.web.json;

import com.lrx.web.json.entity.Dog;
import com.lrx.web.json.entity.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.InputStream;

/**
 * @author lrx
 * {@code @date} 2025/3/17 下午8:24
 */
@Controller
@RequestMapping(value = "/json")
public class JsonHandler {

    @RequestMapping(value = "/dog")
//指定返回的数据格式 json ,靠这个@ResponseBody
    @ResponseBody
    public Dog getJson() {
//创建一只狗
        Dog dog = new Dog();
        dog.setName("大黄狗");
        dog.setAddress("北京八达岭~");
        return dog;
    }
    @PostMapping("/save2")
    @ResponseBody
    public User save2(@RequestBody User user){
//将前台传过来的数据 以 json 的格式相应回浏览器
        System.out.println("user~= " + user);
        return user ;
    }
    @RequestMapping(value = "downFile")
    public ResponseEntity<byte[]> update(HttpSession session) throws Exception {
        InputStream resourceAsStream = session.getServletContext().getResourceAsStream("/image/img.png");

        byte[] bytes = new byte[resourceAsStream.available()];

        resourceAsStream.read(bytes);
        HttpStatus httpStatus = HttpStatus.OK;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=img.png");


        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, httpStatus);
        return responseEntity;

    }
}

