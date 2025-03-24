package com.lrx.mapper;

import com.lrx.entity.Pet;
import com.lrx.entity.User;
import com.lrx.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author lrx
 * {@code @date} 2025/3/23 下午5:56
 */
public class PEtMapperTest {
    private SqlSession sqlSession;
    private PetMapper petMapper;

    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        petMapper = sqlSession.getMapper(PetMapper.class);
    }

    @Test
    public void getPetById() {

        Pet pet = petMapper.getPetById(3);
        System.out.println("pet = " + pet.getNickname() + ", id = " + pet.getId());
        User user = pet.getUser();
        System.out.println("user = " + user.getName());
    }
}
