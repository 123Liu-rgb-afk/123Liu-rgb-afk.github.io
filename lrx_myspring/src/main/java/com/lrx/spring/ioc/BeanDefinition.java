package com.lrx.spring.ioc;

import com.lrx.spring.annotation.Scope;

/**
 * @author lrx
 * {@code @date} 2025/3/8 上午11:42
 * 用于封装Bean的信息
 */
public class BeanDefinition {
    private String scope;
    private Class clazz;

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "BeanDefinition{" +
                "scope='" + scope + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
