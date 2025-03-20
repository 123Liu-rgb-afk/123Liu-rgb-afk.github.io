package com.lrx.mapper;

import com.lrx.entity.Monster;
import com.lrx.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author lrx
 * {@code @date} 2025/3/19 下午4:33
 */
public class MonsterMapperTest {
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
    }

    @Test
    public void addMonster() {
        for (int i = 0; i < 2; i++) {
            Monster monster = new Monster();
            monster.setAge(100 + i); monster.setBirthday(new Date());
            monster.setEmail("tn@sohu.com");
            monster.setGender(1);
             monster.setName("松鼠精" + i);
            monster.setSalary(9234.89 + i * 10);
            monsterMapper.addMonster(monster);
            System.out.println("刚刚添加的对象的 id=" + monster.getId());
        }
        if(sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("添加成功");
    }

    @Test
    public void delMonster() {
        monsterMapper.delMonster(1);
        if(sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("删除成功");
    }
    @Test
    public void updateMonster() {
        Monster monster = new Monster();
        monster.setAge(400);
        monster.setBirthday(new Date());
        monster.setEmail("hspedu@sohu.com");
        monster.setGender(2);
        monster.setName("狐狸精");
        monster.setSalary(9234.89);
        monster.setId(2);
        monsterMapper.updateMonster(monster);
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("修改 ok");
    }
    @Test
    public void getMonsterById() {
        Monster monster = monsterMapper.getMonsterById(2);
        System.out.println(monster);
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("查询成功");
    }


    @Test
    public void findAllMonster() {
        List<Monster> monsters = monsterMapper.findAllMonster();
        for (Monster monster : monsters) {
            System.out.println(monster);

        }
    }

}
