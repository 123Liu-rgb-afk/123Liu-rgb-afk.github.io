package com.lrx.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author lrx
 * {@code @date} 2025/3/3 下午9:22
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof House)
        {
            ((House)bean).setName("上海豪宅");
        }
        System.out.println("beanName:" + beanName + ",bean:" + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("beanName:" + beanName + ",bean:" + bean);
        return bean;
    }
}
