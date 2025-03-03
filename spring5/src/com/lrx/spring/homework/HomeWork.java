package com.lrx.spring.homework;

import com.lrx.spring.bean.Monster;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HomeWork {

    @Test
    public void homework() {
        ClassPathXmlApplicationContext ioc
                = new ClassPathXmlApplicationContext("beans.xml");
        Monster bean = ioc.getBean("com.lrx.spring.bean.Monster#0",Monster.class);

        System.out.println("bean.monsterId" + bean.getMonsterId());
        System.out.println("bean = " + bean);
    }
}
