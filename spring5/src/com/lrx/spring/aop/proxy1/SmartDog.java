package com.lrx.spring.aop.proxy1;

import org.junit.jupiter.api.Test;

/**
 * @author lrx
 * {@code @date} 2025/3/5 下午4:16
 */
public class SmartDog implements SmartAnimalable{
    @Override
    public float getSum(float f1, float f2) {
        return f1 + f2;
    }

    @Override
    public float getSub(float f1, float f2) {
        return f1 - f2;
    }
    @Test
    public void test() {
        SmartAnimalable smartAnimalable = new SmartDog();
        ProxyProvider proxyProvider = new ProxyProvider(smartAnimalable);
        SmartAnimalable proxy = proxyProvider.getProxy();
        float sub = proxy.getSum(20, 10);
        System.out.println("sub = " + sub);
    }
}
