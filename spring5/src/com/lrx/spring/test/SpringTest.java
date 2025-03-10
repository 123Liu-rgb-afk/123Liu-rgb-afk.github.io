package com.lrx.spring.test;


import com.lrx.spring.bean.House;
import com.lrx.spring.bean.Master;
import com.lrx.spring.bean.Monster;
import com.lrx.spring.service.Service;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class SpringTest {
    @Test
    public void setBeanByAnnotation() {
        ApplicationContext ioc
                = new ClassPathXmlApplicationContext("beans4.xml");

        Object userDao = ioc.getBean("userService");
        System.out.println(userDao);

    }

    @Test
    public void postProcess() {
        ApplicationContext ioc
                = new ClassPathXmlApplicationContext("beans2.xml");
        House house = ioc.getBean("house", House.class);
        System.out.println(house);
        ((ConfigurableApplicationContext)ioc).close();

    }

    @Test
    public void getMonsterByFile() {
        ApplicationContext ioc
                = new ClassPathXmlApplicationContext("beans03.xml");
        Monster bean = ioc.getBean("monster1000", Monster.class);
        System.out.println("bean = " + bean);

    }
    @Test
    public void getMonsterByInFactory() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster bean = ioc.getBean("my", Monster.class);
        System.out.println(bean);
    }
    @Test
    public void getMonsterBySTFactory() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster bean = ioc.getBean("myStaticFactory1", Monster.class);
        System.out.println(bean);
    }
    @Test
    public void getMonsterByList() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Master master1 = ioc.getBean("master1", Master.class);
        System.out.println(master1);
    }
    @Test
    public void getMonsterByN() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Service service = ioc.getBean("service2", Service.class);
        System.out.println(service);
    }
    @Test
    public void getMonsterByRef() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Service service = ioc.getBean("service", Service.class);
        System.out.println(service);
    }

    @Test
    public void getMonsterByC() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Monster monster = (Monster) context.getBean("monster04");
        System.out.println(monster);
    }


    @Test
    public void getMonster() {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");

        Monster monster = (Monster) classPathXmlApplicationContext.getBean("monster01");
        System.out.printf("monster = %s\n", monster);

        Monster monster01 = classPathXmlApplicationContext.getBean("monster01", Monster.class);
        System.out.printf("monster01 = %s\n", monster01);
        System.out.printf("monster01 = %s\n", monster01.getMonsterId());

        String[] beanDefinitionNames = classPathXmlApplicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.printf("beanDefinitionName = %s\n", beanDefinitionName);

        }

    }
    //获得类加载路径
    @Test
    public void classPath() {
        File file = new File(this.getClass().getResource("/").getPath());
        System.out.printf("file = %s\n", file);
    }

}
