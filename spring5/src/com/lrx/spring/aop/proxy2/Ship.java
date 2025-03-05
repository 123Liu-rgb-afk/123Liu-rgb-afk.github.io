package com.lrx.spring.aop.proxy2;

/**
 * @author lrx
 * {@code @date} 2025/3/4 下午10:30
 */
public class Ship implements Vehicle{
    @Override
    public void run() {
        System.out.println("船");
    }
}
