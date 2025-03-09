package com.lrx.spring.component;

import com.lrx.spring.annotation.Component;

/**
 * @author lrx
 * {@code @date} 2025/3/8 下午3:01
 */
@Component
public class LrxAspect {
    public static void showBeginLog() {
        System.out.println("前置通知");
    }
    public static void showEndLog() {
        System.out.println("后置通知");
    }
}
