package com.lrx.spring.service;

import com.lrx.spring.dao.Dao;

public class Service {
    private Dao dao;

    public Service() {
        System.out.println("service 构造器被调用");
    }
    public void add(){
        System.out.println("service add");
        dao.add();
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        System.out.println("service setDao");
        this.dao = dao;
    }
}
