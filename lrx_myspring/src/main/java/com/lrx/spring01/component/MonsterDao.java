package com.lrx.spring01.component;

import com.lrx.spring01.anootation.Component;
import com.lrx.spring01.proxy.InitializingBean;

/**
 * @author lrx
 * {@code @date} 2025/3/8 下午6:58
 */
@Component(value = "monsterDao")
public class MonsterDao implements InitializingBean {
    public void hi() {
        System.out.println("MonsterDao.hi");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MonsterDao.afterPropertiesSet");
    }
}
