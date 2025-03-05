package com.lrx.spring.aop.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lrx
 * {@code @date} 2025/3/4 下午10:30
 */
public class VehicleProxyProvider {
    private Vehicle target_vehicle;

    public VehicleProxyProvider(Vehicle target_vehicle) {
        this.target_vehicle = target_vehicle;
    }
    public Vehicle getProxy() {
        /*
        public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
        throws IllegalArgumentException
         */
        ClassLoader classLoader = target_vehicle.getClass().getClassLoader();
        Class<?>[] interfaces = target_vehicle.getClass().getInterfaces();

        /*
        public interface InvocationHandler {
        public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable;
}
         */
        InvocationHandler invocationHandler = new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("开始");
                Object invoke = method.invoke(target_vehicle, args);
                System.out.println("结束");
                return invoke;
            }

        };
        Vehicle proxy = (Vehicle)Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
        return proxy;
    }
}
