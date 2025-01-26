package com.lrx.tomcat;

import com.lrx.myServlet.MyHttpServlet;
import com.lrx.tomcat.handle.HttpRequestHandle;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formattable;
import java.util.HashMap;
import java.util.List;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class MyTomcatV3 {
    public static final HashMap<String,String> servletUriMapping= new HashMap<>();
    public static final HashMap<String, MyHttpServlet> servletMapping= new HashMap<>();

    public static void main(String[] args)  {
        MyTomcatV3 myTomcatV3 = new MyTomcatV3();
        myTomcatV3.init();
        myTomcatV3.run();

    }
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务器在8888端口监听");
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                HttpRequestHandle httpRequestHandle = new HttpRequestHandle(socket);
                new Thread(httpRequestHandle).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //初始化
    public void init() {
        String path = MyTomcatV3.class.getResource("/").getPath();


        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new File(path + "web.xml"));

            Element rootElement = document.getRootElement();
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                if("servlet".equalsIgnoreCase(element.getName())) {
                    Element servletName = element.element("servlet-name");
                    Element servletClass = element.element("servlet-class");
                    servletMapping.put(servletName.getText(),(MyHttpServlet) Class.forName(servletClass.getText()).newInstance());


                }else if("servlet-mapping".equalsIgnoreCase(element.getName())) {
                    Element servletName = element.element("servlet-name");
                    Element urlPattern = element.element("url-pattern");
                    servletUriMapping.put(urlPattern.getText(),servletName.getText());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

