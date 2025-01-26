package com.lrx.utils;

import com.lrx.tomcat.MyTomcatV3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class WebUtils {
    public static int parseInt(String strNum, int defaulVal){
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            System.out.println(strNum + "格式不对");
        }
        return defaulVal;
    }
    public static boolean isHtml(String uri) {
        return uri.endsWith(".html");
    }

    public static String readHtml(String fileName) {
        //String path = WebUtils.class.getResource("/").getPath();
        String path = WebUtils.class.getResource("/").getPath();

        System.out.println(path + fileName);
        System.out.println(path);
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(path + fileName));
            String str = "";
            while((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();


    }
}
