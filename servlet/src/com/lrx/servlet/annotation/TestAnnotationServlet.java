package com.lrx.servlet.annotation;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.HashMap;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class TestAnnotationServlet  {
    private static final HashMap<String, Object> hm = new HashMap<>();
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        //1. 首先要得到扫描的包 ， 路径IO，进而得到类的全路径
        String classPath = "com.lrx.servlet.annotation.OKServlet";

        Class<?> aClass = Class.forName(classPath);

        WebServlet annotation = aClass.getAnnotation(WebServlet.class);
        String[] strings = annotation.urlPatterns();
        for (String url : strings) {
            System.out.println("url=" + url);
        }
        Object instance = aClass.newInstance();
        hm.put("OkServlet",instance);
    }

}
