package com.lrx.spring.aop.proxy3;

import org.springframework.stereotype.Component;

/**
 * @author lrx
 * {@code @date} 2025/3/5 下午8:34
 */
@Component
public class Car {
    public void run() {
        System.out.println("run");
    }
}
