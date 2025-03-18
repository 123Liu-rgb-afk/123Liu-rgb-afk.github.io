package com.lrx.web.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author lrx
 * {@code @date} 2025/3/18 下午12:23
 */
@Controller
public class FileUploadHandler {

    @RequestMapping(value = "/fileUpload")
    public String handleFileUpload(HttpServletRequest request, @RequestParam(value = "file") MultipartFile file) throws IOException {

            String originalFilename = file.getOriginalFilename();
            System.out.println("上传文件名= " + originalFilename);
            String filepath = request.getServletContext().getRealPath("/image/" + originalFilename);
            //转存到 d:/kk.jpg
            File saveToFile = new File(filepath);
            file.transferTo(saveToFile);
            return "success";

    }
}
