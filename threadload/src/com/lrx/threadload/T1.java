package com.lrx.threadload;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class T1{
    public static ThreadLocal<Object> ThreadLocal1 = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(new Test()).start();
    }

    public static class Test implements Runnable {

        @Override
        public void run() {
            Pig pig = new Pig();
            Dog dog = new Dog();
            /*
            public void set(T value) {
            //先获得当前线程，根据当前线程获得ThreadLocalMap
                Thread t = Thread.currentThread();
                ThreadLocalMap map = getMap(t);
                if (map != null)
                //this指的是ThreadLocal1，谁调用就指的是谁
                    map.set(this, value);
                else
                     createMap(t, value);
              }
             */

            ThreadLocal1.set(dog);
            ThreadLocal1.set(pig);
            String name = Thread.currentThread().getName();
            System.out.println("T1 线程name=" + name);
            new T1Service().updata();
        }
    }

}
