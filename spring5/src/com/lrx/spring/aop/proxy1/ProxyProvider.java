package com.lrx.spring.aop.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lrx
 * {@code @date} 2025/3/5 下午4:17
 */
public class ProxyProvider {
    private SmartAnimalable target_smartDog;

    public ProxyProvider(SmartAnimalable target_smartDog) {
        this.target_smartDog = target_smartDog;
    }
    public SmartAnimalable getProxy () {
        ClassLoader classLoader = this.target_smartDog.getClass().getClassLoader();
        Class<?>[] interfaces = this.target_smartDog.getClass().getInterfaces();
        InvocationHandler invocationHandler
                = new InvocationHandler(){

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = method.invoke(target_smartDog, args);
                return invoke;

            };
        };
        Object o = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return (SmartAnimalable) o;
    }
}
