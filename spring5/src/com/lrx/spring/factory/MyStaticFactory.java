package com.lrx.spring.factory;

import com.lrx.spring.bean.Monster;

import java.util.HashMap;
import java.util.Map;

public class MyStaticFactory {

    private static Map<String, Monster> monsterMap;
    static {
        monsterMap = new HashMap<String, Monster>();
        monsterMap.put("monster_01", new Monster(100, "黄袍怪", "一阳指"));
        monsterMap.put("monster_02", new Monster(200, "九头金雕", "如来神掌"));

    }
    public static Monster getMonster(String key) {
        return monsterMap.get(key);
    }


}
