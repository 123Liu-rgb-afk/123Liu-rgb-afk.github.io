package com.lrx.entity;

import java.util.List;

/**
 * @author lrx
 * {@code @date} 2025/3/23 下午5:26
 */
public class User {
    private Integer id;
    private String name;
    private List<Pet> pets;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
