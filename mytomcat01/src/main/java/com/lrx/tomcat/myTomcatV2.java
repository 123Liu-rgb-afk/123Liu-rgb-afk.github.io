package com.lrx.tomcat;

import com.lrx.tomcat.handle.HttpRequestHandle;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 刘瑞玺
 * @version 1.0
 * 这是第一个版本的tomcat，完成 接时候浏览器的请求
 */
public class myTomcatV2 {
    public static void main(String[] args) throws IOException {

        //1.创建一个ServerSocket 在8888端口监听
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器在8888端口监听");
        while (!serverSocket.isClosed()) {
            Socket socket = serverSocket.accept();
            HttpRequestHandle httpRequestHandle = new HttpRequestHandle(socket);
            new Thread(httpRequestHandle).start();

        }

    }
}
