package com.lrx.spring;

import com.lrx.spring.component.MonsterDao;
import com.lrx.spring.component.MonsterService;
import com.lrx.spring.ioc.LrxSpringApplicatinContext;
import com.lrx.spring.ioc.LrxSpringConfig;

/**
 * @author lrx
 * {@code @date} 2025/3/8 上午11:31
 */
public class APPMain {
    public static void main(String[] args) {
        LrxSpringApplicatinContext ioc
                = new LrxSpringApplicatinContext(LrxSpringConfig.class);
        MonsterService monsterService
                = (MonsterService)ioc.getBean("monsterService");

        MonsterService monsterService2
                = (MonsterService)ioc.getBean("monsterService");
        System.out.println("monsterService: " + monsterService);
        System.out.println("monsterService2: " + monsterService2);


        MonsterDao monsterDao = (MonsterDao)ioc.getBean("monsterDao");
        MonsterDao monsterDao2 = (MonsterDao)ioc.getBean("monsterDao");
        System.out.println("monsterDao: " + monsterDao);
        System.out.println("monsterDao2: " + monsterDao2);

        monsterService.hi();

    }
}
