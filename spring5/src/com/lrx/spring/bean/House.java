package com.lrx.spring.bean;

/**
 * @author lrx
 * {@code @date} 2025/3/3 下午9:11
 */
public class House {
    private String name;

    public House() {
        System.out.println("House constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("House setter=" + name);
        this.name = name;
    }

    public void init() {
        System.out.println("House init");
    }
    public void destroy() {
        System.out.println("House destroy");
    }
    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                '}';
    }
}
