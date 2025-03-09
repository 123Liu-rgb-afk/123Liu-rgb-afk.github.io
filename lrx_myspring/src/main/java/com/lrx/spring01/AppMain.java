package com.lrx.spring01;

import com.lrx.spring01.component.MonsterService;
import com.lrx.spring01.ioc.LrxSpringApplicationContext;
import com.lrx.spring01.ioc.LrxSpringConfig;


/**
 * @author lrx
 * {@code @date} 2025/3/8 下午7:01
 */
public class AppMain {
    public static void main(String[] args) {

        LrxSpringApplicationContext ioc = new LrxSpringApplicationContext(LrxSpringConfig.class);
//        Object bean = ioc.getBean("monsterService01");
//        Object bean1 = ioc.getBean("monsterService01");
//        System.out.println(bean1);
//        System.out.println(bean);
        Object bean2 = ioc.getBean("monsterDao");
        Object bean3 = ioc.getBean("monsterDao");
        System.out.println(bean2);
        System.out.println(bean3);
        MonsterService bean = (MonsterService) ioc.getBean("monsterService01");
        System.out.println(bean);
        bean.hi();



    }
}
