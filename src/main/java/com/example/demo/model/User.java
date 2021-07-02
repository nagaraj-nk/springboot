package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "jpa_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String userpassword;

    public User(){
        super();
    }

    public User(int id, String username, String userpassword) {
        this.id = id;
        this.username = username;
        this.userpassword = userpassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", dept='" + userpassword + '\'' +
                '}';
    }
}
