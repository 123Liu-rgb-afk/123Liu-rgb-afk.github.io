package com.lrx.mapper;

import com.lrx.entity.Monster;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author lrx
 * {@code @date} 2025/3/20 下午9:53
 */
public interface MonsterAnnotation {
    //添加语句方法
    @Insert("INSERT INTO monster (age,birthday,email,gender,name,salary) VALUES(#{age},#{birthday},#{email},#{gender},#{name},#{salary})")
    public void addMonster(Monster monster);
    //通过id删除语句
    @Delete(" DELETE FROM monster WHERE id = #{id}")
    public void delMonster(Integer id);
    //更新
    @Update(" UPDATE monster SET age=#{age}, birthday=#{birthday}, email = #{email}, gender= #{gender}, name=#{name}, salary=#{salary} WHERE id=#{id}")
    public void updateMonster(Monster monster);
    //查询-根据 id
    @Select("SELECT * FROM monster where id = #{id}")
    public Monster getMonsterById(Integer id);
    //查询所有的 Monster
    @Select("select * from monster")
    public List<Monster> findAllMonster();
}

