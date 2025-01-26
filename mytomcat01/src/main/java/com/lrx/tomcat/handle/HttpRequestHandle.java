package com.lrx.tomcat.handle;

import com.lrx.http.MyHttpServletRequest;
import com.lrx.http.MyHttpServletRespond;
import com.lrx.myServlet.MyCalServelt;
import com.lrx.myServlet.MyHttpServlet;
import com.lrx.tomcat.MyTomcatV3;
import com.lrx.tomcat.myTomcatV1;
import com.lrx.utils.WebUtils;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class HttpRequestHandle implements Runnable{
    private Socket socket = null;

    public HttpRequestHandle(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
//            InputStream inputStream = socket.getInputStream();
//            BufferedReader bufferedReader
//                    = new BufferedReader(new InputStreamReader(inputStream));
//
//            System.out.println("=========请求=========");
//
//            String str = null;
//            while((str = bufferedReader.readLine()) != null){
//                if(str.length() == 0) {
//                    break;
//                }
//                System.out.println(str);
//            }

            MyHttpServletRequest myHttpServletRequest = new MyHttpServletRequest(socket.getInputStream());
            System.out.println(myHttpServletRequest.toString());


//            OutputStream outputStream = socket.getOutputStream();
//            String respHead = "HTTP/1.1 200 ok\r\n" +
//                    "Content-Type: text/html;charset=utf-8\r\n\r\n";
//            String resp = respHead + "hi 刘";
//            outputStream.write(resp.getBytes());
//
//            System.out.println("=======响应========");
//            System.out.println(resp);

            MyHttpServletRespond myHttpServletRespond = new MyHttpServletRespond(socket.getOutputStream());
//            OutputStream outputStream = myHttpServletRespond.getOutputStream();
//            String resp= myHttpServletRespond.respHead + "hi 刘";
//            outputStream.write(resp.getBytes());
//            System.out.println("=======响应========");
//            System.out.println(resp);
//            MyCalServelt myCalServelt = new MyCalServelt();
//            myCalServelt.doGet(myHttpServletRequest,myHttpServletRespond);

            String uri = myHttpServletRequest.getUri();

            if(WebUtils.isHtml(uri)) {
                String content = WebUtils.readHtml(uri.substring(1));
                content = MyHttpServletRespond.respHead + content;
                System.out.println(content);
                OutputStream outputStream = myHttpServletRespond.getOutputStream();
                outputStream.write(content.getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
                outputStream.close();
                socket.close();

            }
            String servletName = MyTomcatV3.servletUriMapping.get(uri);

            MyHttpServlet myHttpServlet = MyTomcatV3.servletMapping.get(servletName);

            if(myHttpServlet != null) {
                myHttpServlet.service(myHttpServletRequest,myHttpServletRespond);

            }else {
                OutputStream outputStream = myHttpServletRespond.getOutputStream();
                outputStream.write((MyHttpServletRespond.respHead + "404").getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
                outputStream.close();
            }



//            outputStream.flush();
//            outputStream.close();

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
