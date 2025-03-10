package com.lrx.spring.annotation;

/**
 * @author lrx
 * {@code @date} 2025/3/4 下午9:38
 */
public class Test {
    public static void main(String[] args) {
        LrxSpringApplicationContext ioc
                = new LrxSpringApplicationContext(LrxSpringConfig.class);
        Object userDao = ioc.getBean("userDao");
        Object my01 = ioc.getBean("my01");
        System.out.println(my01);
        System.out.println(userDao);
    }
}
