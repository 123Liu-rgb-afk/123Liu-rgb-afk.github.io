package com.lrx.spring.component;

import com.lrx.spring.annotation.Component;
import com.lrx.spring.process.BeanPostProcess;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lrx
 * {@code @date} 2025/3/8 下午2:23
 */
@Component
public class LrxBeanPostProcessor implements BeanPostProcess {
    @Override
    public Object processBeforeInitialization(Object bean, String beanName) {
        System.out.println("后置处理器 - before" + bean.getClass() + " " + beanName);
        return bean;
    }

    @Override
    public Object processAfterInitialization(Object bean, String beanName) {
        System.out.println("后置处理器 - after" + bean.getClass() + " " + beanName);

        if("smartDog".equals(beanName)){
            Object proxy = Proxy.newProxyInstance(LrxBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    Object result = null;
                    if (method.getName().equalsIgnoreCase("getSum")) {
                        LrxAspect.showBeginLog();
                        result = method.invoke(bean, args);
                        LrxAspect.showEndLog();
                        return result;
                    }else {
                        result = method.invoke(bean, args);
                    }

                    return result;
                }
            });
            return proxy;

        }
        return bean;
    }
}
