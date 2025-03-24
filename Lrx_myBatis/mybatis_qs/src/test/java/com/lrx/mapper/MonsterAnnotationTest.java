package com.lrx.mapper;

import com.lrx.entity.Monster;
import com.lrx.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * @author lrx
 * {@code @date} 2025/3/20 下午9:56
 */
public class MonsterAnnotationTest {
    private SqlSession sqlSession;
    private MonsterAnnotation monsterAnnotation;

    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        monsterAnnotation = sqlSession.getMapper(MonsterAnnotation.class);
    }

    @Test
    public void addMonster() {
        for (int i = 0; i < 2; i++) {
            Monster monster = new Monster();
            monster.setAge(100 + i); monster.setBirthday(new Date());
            monster.setEmail("tn@sohu.com");
            monster.setGender(1);
            monster.setName("爱你" + i);
            monster.setSalary(9234.89 + i * 10);
            monsterAnnotation.addMonster(monster);
            System.out.println("刚刚添加的对象的 id=" + monster.getId());
        }
        if(sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("添加成功");
    }
}
