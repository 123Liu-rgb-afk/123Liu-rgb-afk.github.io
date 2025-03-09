package com.lrx.spring;

import com.lrx.spring.component.SmartAnimal;
import com.lrx.spring.ioc.LrxSpringApplicatinContext;
import com.lrx.spring.ioc.LrxSpringConfig;

/**
 * @author lrx
 * {@code @date} 2025/3/8 下午3:13
 */
public class APPAOP {
    public static void main(String[] args) {

        LrxSpringApplicatinContext ioc = new LrxSpringApplicatinContext(LrxSpringConfig.class);
        SmartAnimal bean =(SmartAnimal)ioc.getBean("smartDog");
        bean.getSum(19,10);

    }
}
