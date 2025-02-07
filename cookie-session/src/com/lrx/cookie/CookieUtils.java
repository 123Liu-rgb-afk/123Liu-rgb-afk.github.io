package com.lrx.cookie;

import javax.servlet.http.Cookie;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class CookieUtils {
    //读取指定的Cookie
    public static Cookie ReadCookieByName(String name,Cookie[] cookies){
        if(name == null || "".equals(name) || cookies == null || cookies.length == 0) {
            return null;

        }
        for (Cookie cookie : cookies) {
           if(cookie.getName().equals(name)){
               return cookie;
           }

        }
        return null;

    }
}
