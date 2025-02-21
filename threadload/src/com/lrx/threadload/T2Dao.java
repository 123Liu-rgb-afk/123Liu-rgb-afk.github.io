package com.lrx.threadload;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class T2Dao {
    public void updata() {
        //获得线程名字
        String name = Thread.currentThread().getName();
        System.out.println("T2Dao 线程name=" + name);
        /*
        public T get() {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            ThreadLocalMap.Entry e = map.getEntry(this);
            if (e != null) {
                @SuppressWarnings("unchecked")
                T result = (T)e.value;
                return result;
            }
         }
            return setInitialValue();
         }
         */
        Object o = T1.ThreadLocal1.get();
        System.out.println(o);
    }
}
