package com.lrx.mapper;

import com.lrx.entity.Person;
import com.lrx.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lrx
 * {@code @date} 2025/3/23 下午3:41
 */
public class AnnotationTest {
    private SqlSession sqlSession;
    private PersonMapperAnnotation personMapperAnnotation;
    @Before

    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        personMapperAnnotation = sqlSession.getMapper(PersonMapperAnnotation.class);

    }

    @Test
    public void getPersonById() {
        Person person = personMapperAnnotation.getPersonById(1);
        System.out.println(person);
        if(sqlSession != null) {
            sqlSession.close();
        }
    }
}
