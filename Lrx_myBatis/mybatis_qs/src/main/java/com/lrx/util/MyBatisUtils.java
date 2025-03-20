package com.lrx.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lrx
 * {@code @date} 2025/3/19 下午4:14
 * 可以得到sqlsession
 */

public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    //初始化sqlSessionFactory
    static {

        try {
            //先拿到资源
            String resource = "mybatis-config.xml";

            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            System.out.println(sqlSessionFactory.getClass());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }


}
