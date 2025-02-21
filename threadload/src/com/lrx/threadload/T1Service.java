package com.lrx.threadload;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class T1Service {
    public void updata() {
        //获得线程名字
        String name = Thread.currentThread().getName();
        System.out.println("T1Service 线程name=" + name);
        new T2Dao().updata();
    }
}
