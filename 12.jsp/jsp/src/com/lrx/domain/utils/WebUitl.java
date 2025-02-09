package com.lrx.domain.utils;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class WebUitl {
    public static int parseInt(String strNum,int defauleVal) {
        try {
            return Integer.parseInt(strNum);
        } catch (NumberFormatException e) {
            System.out.println("不能转换成整数");
        }
        return defauleVal;
    }

}
