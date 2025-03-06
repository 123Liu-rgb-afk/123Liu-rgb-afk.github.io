package com.lrx.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author lrx
 * {@code @date} 2025/3/6 下午9:52
 */
@Component
public class SmartDog implements SmartAnimalable{
    @Override
    public float getSum(float i, float j) {
        float result = i + j;
        System.out.println("getSum() 方法内部打印 result= " + result);
        return result;
    }
    @Override
    public float getSub(float i, float j) {
        float result = i - j;
        System.out.println("getSub() 方法内部打印 result= " + result);
        return result;
    }
}
