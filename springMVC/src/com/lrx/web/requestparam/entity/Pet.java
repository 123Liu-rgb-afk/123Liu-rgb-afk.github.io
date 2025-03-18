package com.lrx.web.requestparam.entity;

/**
 * @author lrx
 * {@code @date} 2025/3/11 下午9:03
 */
public class Pet {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
