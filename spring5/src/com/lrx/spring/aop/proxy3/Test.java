package com.lrx.spring.aop.proxy3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author lrx
 * {@code @date} 2025/3/5 下午4:25
 */
public class Test {

    @org.junit.jupiter.api.Test
    public void test() {
        ApplicationContext ioc
                = new ClassPathXmlApplicationContext("beans5.xml");
        SmartAnimalable beans = ioc.getBean(SmartAnimalable.class);
        System.out.println(beans.getClass());
        beans.getSum(10, 10);
    }


    @org.junit.jupiter.api.Test
    public void test2() {
        ApplicationContext ioc
                = new ClassPathXmlApplicationContext("beans5.xml");
        Object car = ioc.getBean("car");
        ((Car)car).run();
        System.out.println(car.getClass());

    }


}
