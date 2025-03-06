package com.lrx.spring.component;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author lrx
 * {@code @date} 2025/3/6 下午8:34
 */
@Component
//@Service

public class UserService {
    @Autowired
    //@Resource
    private UserDao userDao;
    public void hi() {
        System.out.println("UserService hi");
        userDao.hi();
    }
    @PostConstruct
    public void init() {
        System.out.println("UserService init");
    }
}
