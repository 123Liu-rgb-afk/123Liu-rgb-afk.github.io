package com.lrx.spring.process;

/**
 * @author lrx
 * {@code @date} 2025/3/8 下午2:20
 */
public interface BeanPostProcess {
    default Object processAfterInitialization(Object bean, String beanName) {
        return bean;
    };
    default Object processBeforeInitialization(Object bean, String beanName) {
        return bean;
    }
}
