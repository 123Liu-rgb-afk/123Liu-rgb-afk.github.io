package com.lrx.spring01.ioc;

/**
 * @author lrx
 * {@code @date} 2025/3/8 下午7:17
 */
public class BenaDifinition {
    private String scope;
    private Class clazz;

    public BenaDifinition() {
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "BenaDifinition{" +
                "scope='" + scope + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
