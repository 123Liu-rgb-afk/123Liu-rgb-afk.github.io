package com.lrx.entity;

/**
 * @author lrx
 * {@code @date} 2025/3/23 下午2:44
 */


public class Person {

    private Integer id;
    private String name;
    private IdenCard card;

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

    public IdenCard getCard() {
        return card;
    }

    public void setCard(IdenCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", card=" + card +
                '}';
    }
}
