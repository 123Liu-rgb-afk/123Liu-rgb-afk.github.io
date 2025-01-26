package com.lrx.http;

import java.io.OutputStream;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class MyHttpServletRespond {
    private OutputStream outputStream = null;
    public final static String respHead = "HTTP/1.1 200 ok\r\n" +
            "Content-Type: text/html;charset=utf-8\r\n\r\n";

    public MyHttpServletRespond(OutputStream outputStream) {
        this.outputStream = outputStream;

    }

    public static String getRespHead() {
        return respHead;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
