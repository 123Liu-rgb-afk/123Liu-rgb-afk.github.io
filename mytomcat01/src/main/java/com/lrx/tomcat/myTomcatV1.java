package com.lrx.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 刘瑞玺
 * @version 1.0
 * 这是第一个版本的tomcat，完成 接时候浏览器的请求
 */
public class myTomcatV1 {
    public static void main(String[] args) throws IOException {

        //1.创建一个ServerSocket 在8888端口监听
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器在8888端口监听");
        while (!serverSocket.isClosed()) {
            Socket scoket = serverSocket.accept();
            InputStream inputStream = scoket.getInputStream();
            OutputStream outputStream = scoket.getOutputStream();
            BufferedReader bufferedReader
                    = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));

            String str = null;
            while((str = bufferedReader.readLine()) != null) {
                //判断str的长度
                if(str.length() == 0) {
                    break;
                }
                System.out.println(str);
            }
             String respHead = "HTTP/1.1 200 ok\r\n" +
                     "Content-Type: text/html;charset=utf-8\r\n\r\n";
             String resp = respHead + "hi , 老刘";
             outputStream.write(resp.getBytes());
             System.out.println("=======响应头=========");
             System.out.println(resp);

             outputStream.flush();
             outputStream.close();
             inputStream.close();
             scoket.close();
        }


    }
}
