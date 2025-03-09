package com.lrx.spring.component;

import com.lrx.spring.annotation.Autowired;
import com.lrx.spring.annotation.Component;
import com.lrx.spring.annotation.Scope;
import com.lrx.spring.process.InitializingBean;

/**
 * @author lrx
 * {@code @date} 2025/3/8 上午11:23
 */
@Component
@Scope(value = "protoType")
public class MonsterService implements InitializingBean {
    @Autowired
    private MonsterDao monsterDao;
    public void hi() {
        monsterDao.hi();
        System.out.println("MonsterService hi");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MonsterService afterPropertiesSet 初始化方法");
    }
}
