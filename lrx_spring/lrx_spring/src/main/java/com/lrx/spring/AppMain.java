package com.lrx.spring;

import com.lrx.spring.aop.SmartAnimalable;
import com.lrx.spring.component.UserAction;
import com.lrx.spring.component.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Target;

/**
 * @author lrx
 * {@code @date} 2025/3/6 下午8:41
 */
public class AppMain {
    @Test
    public void setBean() {
        ApplicationContext ioc
                = new ClassPathXmlApplicationContext("beans.xml");

        UserService userService = ioc.getBean("userService", UserService.class);
        UserAction userAction = ioc.getBean("userAction", UserAction.class);

        UserAction userAction2 = ioc.getBean("userAction", UserAction.class);
        System.out.println(userAction);

        System.out.println(userAction2);
        userService.hi();
        System.out.println("userService=" + userService);

    }
    @Test
    public void setBeanByAOP() {
        ApplicationContext ioc
                = new ClassPathXmlApplicationContext("beans.xml");

        SmartAnimalable bean = ioc.getBean(SmartAnimalable.class);
        System.out.println(bean.getClass());
        bean.getSum(19,1);

    }
}
