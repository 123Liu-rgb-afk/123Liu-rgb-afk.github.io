package com.lrx.spring.component;

import com.lrx.spring.annotation.Component;
import com.lrx.spring.process.InitializingBean;

/**
 * @author lrx
 * {@code @date} 2025/3/8 上午11:24
 */
@Component(value = "monsterDao")
public class MonsterDao implements InitializingBean {
    public void hi() {
        System.out.println("MonsterDao hi");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MonsterDao afterPropertiesSet 初始化方法被调用");
    }
}
