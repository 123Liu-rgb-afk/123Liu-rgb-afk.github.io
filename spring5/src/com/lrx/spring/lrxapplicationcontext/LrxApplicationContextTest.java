package com.lrx.spring.lrxapplicationcontext;

//简单spring容器机制

import org.dom4j.DocumentException;

import java.util.concurrent.ConcurrentHashMap;

public class LrxApplicationContextTest {
    public static void main(String[] args) throws Exception {

        LrxApplicationContext ioc =
                new LrxApplicationContext("beans.xml");
        System.out.printf("ok");

    }

}
