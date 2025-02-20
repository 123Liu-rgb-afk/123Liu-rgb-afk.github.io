package com.lrx.ajax.service;

import com.lrx.ajax.dao.UserDao;
import com.lrx.ajax.javabean.User;
import com.lrx.ajax.utils.JDBCUtilsByDriud;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class UserServlice {

    private UserDao userDao = new UserDao();
    public  User getUserByName(String username) {

        User user = userDao.querySingle
                ("select * from `user` where username=?", User.class, username);
        return user;
    }
}
