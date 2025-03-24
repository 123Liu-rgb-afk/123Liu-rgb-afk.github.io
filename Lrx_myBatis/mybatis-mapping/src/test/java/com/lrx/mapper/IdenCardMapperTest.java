package com.lrx.mapper;

import com.lrx.entity.IdenCard;
import com.lrx.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lrx
 * {@code @date} 2025/3/23 下午2:57
 */
public class IdenCardMapperTest {
    private SqlSession sqlSession;
    private IdenCardMapper idenCardMapper;

    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        idenCardMapper = sqlSession.getMapper(IdenCardMapper.class);
    }

    @Test
    public void getIdenCardById() {
        IdenCard idenCardById = idenCardMapper.getIdenCardById(1);
        System.out.println(idenCardById);

        if(sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void getIdenCardById2() {
        IdenCard idenCardById = idenCardMapper.getIdenCardById2(1);
        System.out.println(idenCardById);

        if(sqlSession != null) {
            sqlSession.close();
        }
    }
}
