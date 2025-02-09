package com.lrx.domain;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class Monster {
    private int id;
    private String name;
    private String skill;

    public Monster(int id, String name, String skill) {
        this.id = id;
        this.name = name;
        this.skill = skill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
