package com.lrx.ajax.javabean;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class User {
    private Integer id;
    private String name;
    private String pwd;
    private String email;

    public User() {
    }

    public User(Integer id, String name, String pwd, String email) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.email = email;
    }

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
