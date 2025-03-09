package com.lrx.spring.component;

import com.lrx.spring.annotation.Component;

/**
 * @author lrx
 * {@code @date} 2025/3/8 下午3:00
 */
@Component
public class SmartDog implements SmartAnimal{
    @Override
    public void getSum(float f1, float f2) {
        float result = f1 + f2;

        System.out.println(result);
    }

    @Override
    public void getSub(float f1, float f2) {
        float result = f1 - f2;

        System.out.println(result);
    }
}
