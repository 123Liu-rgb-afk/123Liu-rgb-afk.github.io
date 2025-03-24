package com.lrx.entity;

/**
 * @author lrx
 * {@code @date} 2025/3/23 下午5:26
 */
public class Pet {
    private Integer id;
    private String nickname;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
