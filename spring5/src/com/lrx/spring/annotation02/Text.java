package com.lrx.spring.annotation02;

/**
 * @author lrx
 * {@code @date} 2025/3/8 上午9:38
 */
public class Text {
    public static void main(String[] args) {
        SpringApplicationContext ioc
                = new SpringApplicationContext(SpringConfig.class);
        Object my01 = ioc.getBean("my01");
        System.out.println(my01);
    }
}
