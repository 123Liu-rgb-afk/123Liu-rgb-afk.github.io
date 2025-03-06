package com.lrx.spring.component;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author lrx
 * {@code @date} 2025/3/6 下午8:33
 */
@Component
//@Repository
public class UserDao {
    public void hi() {
        System.out.println("UserDao.hi");
    }
}
