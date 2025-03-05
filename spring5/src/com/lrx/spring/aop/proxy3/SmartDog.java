package com.lrx.spring.aop.proxy3;

import org.springframework.stereotype.Component;

/**
 * @author lrx
 * {@code @date} 2025/3/5 下午4:16
 */
@Component
public class SmartDog implements SmartAnimalable {
    @Override
    public float getSum(float f1, float f2) {
        float res = f1 + f2;
        
        System.out.println("方法内部打印res=" + res);
        return res;
    }

    @Override
    public float getSub(float f1, float f2) {
        float res = f1 - f2;
        System.out.println("方法内部打印res=" + res);
        return res;
    }

}
