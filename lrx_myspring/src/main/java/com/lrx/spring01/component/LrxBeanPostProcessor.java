package com.lrx.spring01.component;


import com.lrx.spring01.anootation.Component;
import com.lrx.spring01.proxy.BeanPostProcess;

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


        return bean;
    }
}
