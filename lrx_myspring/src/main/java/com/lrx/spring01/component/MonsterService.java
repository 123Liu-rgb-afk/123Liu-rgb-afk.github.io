package com.lrx.spring01.component;

import com.lrx.spring01.anootation.Autowired;
import com.lrx.spring01.anootation.Component;
import com.lrx.spring01.anootation.Scope;

/**
 * @author lrx
 * {@code @date} 2025/3/8 下午6:58
 */
@Component(value = "monsterService01")
@Scope(value = "prototype")
public class MonsterService {
    @Autowired
    private MonsterDao monsterDao;
    public void hi() {
        monsterDao.hi();
        System.out.println("MonsterService hi");
    }
}
