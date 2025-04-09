package com.lrx.springbootusersys.controller;

import com.lrx.springbootusersys.utils.WebUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.UUID;

/**
 * @author lrx
 * {@code @date} 2025/4/9 下午4:23
 */
@Slf4j
@Controller
public class UploadController {

    @GetMapping("/upload.html")
    public String uploadPage() {
        return "upload";
    }

    @ResponseBody
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("name") String name,
                         @RequestParam("age") Integer age,
                         @RequestParam("job") String job,
                         @RequestPart("header") MultipartFile header,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException, URISyntaxException {
        log.info("上传的信息：email={}，name={}，age={}, job={}, header={}，photos={}", email, name, age, job, header.getSize(), photos.length);
        URI uri = ResourceUtils.getURL("classpath:").toURI();
        String path = uri.getPath();


        System.out.println("path=" + path) ;
        File file = new File(path + WebUtils.getUploadFile());
        if(!file.exists()){
            file.mkdirs();
        }
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());

        if(!header.isEmpty()){
            System.out.println("file" +file.getAbsolutePath());
            String originalFilename = header.getOriginalFilename();
            originalFilename = UUID.randomUUID().toString() + "_" + System.currentTimeMillis() + "_" + originalFilename;
            header.transferTo(new File(file.getAbsolutePath() + "/" +  originalFilename));
        }
        if(photos.length > 0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    originalFilename = UUID.randomUUID().toString() + "_" + System.currentTimeMillis() + "_" + originalFilename;
                    photo.transferTo(new File(file.getAbsolutePath() + "/" +  originalFilename));

                }

            }
        }
        return "success";
    }
}


