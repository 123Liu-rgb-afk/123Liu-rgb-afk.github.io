package com.lrx.spring.homework;

import com.lrx.spring.bean.Car;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Homework02 {
    @Test
    public void getCar() {
        ClassPathXmlApplicationContext ioc
                = new ClassPathXmlApplicationContext("car.xml");

        Car car = ioc.getBean("car", Car.class);
        System.out.println(car);
    }
}
