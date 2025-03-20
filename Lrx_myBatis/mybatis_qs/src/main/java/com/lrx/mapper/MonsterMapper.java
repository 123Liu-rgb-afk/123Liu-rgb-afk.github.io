package com.lrx.mapper;

import com.lrx.entity.Monster;

import java.util.List;

/**
 * @author lrx
 * {@code @date} 2025/3/19 下午4:03
 */
/*
声明对表的操作方法
 */
public interface MonsterMapper {
    //添加语句方法
    public void addMonster(Monster monster);
    //通过id删除语句
    public void delMonster(Integer id);
    //更新
    public void updateMonster(Monster monster);
    //查询-根据 id
    public Monster getMonsterById(Integer id);
    //查询所有的 Monster
    public List<Monster> findAllMonster();
}
