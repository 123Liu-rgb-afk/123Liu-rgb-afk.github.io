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
public class UserMapperTest {
    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void init() {
        sqlSession = MyBatisUtils.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void getUserById() {
        User user = userMapper.getUserById(1);
        System.out.println("user=" + user.getId() + ",name=" + user.getName());
        List<Pet> pets = user.getPets();
        for (Pet pet : pets) {
            System.out.println(pet.getUser()+" " + pet.getNickname());

        }
    }
}
