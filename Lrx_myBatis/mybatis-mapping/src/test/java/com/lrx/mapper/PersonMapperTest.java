package com.lrx.mapper;

import com.lrx.entity.Person;
import com.lrx.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lrx
 * {@code @date} 2025/3/23 下午3:21
 */
public class PersonMapperTest {
    private SqlSession sqlSession;
    private PersonMapper personMapper;

    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        personMapper = sqlSession.getMapper(PersonMapper.class);
    }
    @Test
    public void getPersonById() {
        Person person = personMapper.getPersonById(1);
        System.out.println(person);
        if(sqlSession != null) {
            sqlSession.close();
        }
    }
}
