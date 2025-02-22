package com.lrx.fileupdown;

import com.lrx.utils.WebUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("FileUploadServlet 被调用");
//        //1. 首先判断是不是上传文件的表单,也就是判断表单里面的enctype="multipart/form-dat
//        if(ServletFileUpload.isMultipartContent(req)) {
//
//            //2. 判断上传资源的类型，是文件还是文本
//            //DiskFileItemFactory ,用来构建一个解析上传数据的工具对象
//            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
//            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
//
//            //解决中文乱码问题
//            servletFileUpload.setHeaderEncoding("utf-8");
//            //servletFileUpload 把上传的数据封装到FileItem对象中
//            try {
//                List<FileItem> list = servletFileUpload.parseRequest(req);
//
//                //System.out.println(list);
//                //输出来看一下
//                //[name=bg.png, StoreLocation=D:\韩顺平循序渐进学java\代码\3. Javaweb\apache-tomcat-8.0.50\temp\xupload_244d97ec_19527e5b854__7ef1_00000000.tmp, size=298873bytes, isFormField=false, FieldName=pic,
//                // name=null, StoreLocation=D:\韩顺平循序渐进学java\代码\3. Javaweb\apache-tomcat-8.0.50\temp\xupload_244d97ec_19527e5b854__7ef1_00000001.tmp, size=3bytes, isFormField=true, FieldName=name]
//
//                for (FileItem fileItem : list) {
//                    //3.判断文件还是文本 oop程序员
//                    if(fileItem.isFormField()) {//如果为真，为文本
//                        String name = fileItem.getString();
//                        System.out.println("上传的文本信息="  + name);
//
//                    }else {//假，为文件
//                        String name = fileItem.getName();
//                        System.out.println("文件信息=" + name);
//
//                        // 4. 我们要把服务器发送的文件放到temp下的upload目录下
//                        String filePath = "/upload/";
//                        String realPath = req.getServletContext().getRealPath(filePath);
//                        System.out.println("真正运行的路径=" + realPath);
//
//                        //创建目录
//                        File file = new File(realPath);
//                        if(!file.exists()) {
//                            file.mkdirs();
//                        }
//
//                        //把文件拷贝到目录下
//                        fileItem.write(new File(realPath + "/" + name));
//
//                        //提示服务器上传成功
//                        resp.setContentType("text/html;charset=utf-8");
//                        resp.getWriter().write("上传成功~");
//
//                    }
//
//                }
//
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }else {
//            System.out.println("不是文件上传");
//        }



        //方式1 解决接收到文件名是中文乱码问题
        //req.setCharacterEncoding("utf-8");
        //1， 首先判断是不是文件表单，也就是enctype="multipart/form-data
        if(ServletFileUpload.isMultipartContent(req)) {
            //System.out.println("ok");
            //2. 判断表单提交的类型，是文件类型还是文本类型
            //创建 DiskFileItemFactory 对象，用来构建一个解析上传数据的工具对象
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            //3. 创建解析上传数据的工具对象
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            // 方式2=】
            // ‘-解决接收到文件名是中文乱码问题
            servletFileUpload.setHeaderEncoding("utf-8");
            //4. 怎么解析，servletFileUpload 对象 可以把表单提交的数据
            //封装到FileItem 文件项目中
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                //System.out.println(list);
                //[name=, StoreLocation=D:\韩顺平循序渐进学java\代码\3. Javaweb\apache-tomcat-8.0.50\temp\xupload_11d4250c_19527cce5e6__7fd7_00000000.tmp, size=0bytes, isFormField=false, FieldName=pic,
                //name=null, StoreLocation=D:\韩顺平循序渐进学java\代码\3. Javaweb\apache-tomcat-8.0.50\temp\xupload_11d4250c_19527cce5e6__7fd7_00000001.tmp, size=0bytes, isFormField=true, FieldName=name]
                for (FileItem fileItem : list) {
                    //System.out.println("fileItem=" + fileItem);
                    //判断是不是一个文件，是一个oop程序员，想到有没有方法可以实现
                    if (fileItem.isFormField()) {//如果为真，文本
                        String name = fileItem.getString();

                        System.out.println("name=" + name);

                    } else {//如果为假，就是一个文件
                        //获取文件上传的名字
                        //为什么用getName，因为[name=1.jpg,
                        String name = fileItem.getName();
                        System.out.println("文件名=" + name);

                        //我们拿到文件，上传服务器到temp下的文件保存到你指定的目录
                        //1.指定一个目录,out 下面，但工作路径不确定，获取工作路径
                        String filePath = "/upload/";
                        //真正工作的路径
                        String fileRealPath = req.getServletContext().getRealPath(filePath);
                        System.out.println("真正工作路径=" + fileRealPath);
                        //真正工作路径=D:\韩顺平循序渐进学java\代码\3. Javaweb\19.fileupdown\fileupdown\out\artifacts\fileupdown_war_exploded\xupload\


                        //分目录操作，创建目录年月日
                        String yearMonthDay = WebUtils.getYearMonthDay();
                        File fileRealPathDirectory = new File(fileRealPath + "/" + yearMonthDay);
                        if (!fileRealPathDirectory.exists()) {//判断目录是否存在
                            fileRealPathDirectory.mkdirs();//创建目录

                        }
                        //4. 将文件拷贝到真正运行的目录下
                        //文件名相同解决问题，防止文件覆盖
                        name = UUID.randomUUID().toString() + "_" + System.currentTimeMillis() + "_" + name;

                        fileItem.write(new File(fileRealPathDirectory + "/" + name));

                        //5. 提示信息
                        resp.setContentType("text/html;charset=utf-8");
                        resp.getWriter().write("上传成功~");

                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("不是文件表单");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp);
    }
}
