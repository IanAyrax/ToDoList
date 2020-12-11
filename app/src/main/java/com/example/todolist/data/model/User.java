package com.example.todolist.data.model;

import com.example.todolist.base.BaseModel;

public class User extends BaseModel{
    private String id;
    private String name;
    private String password;
    private String token;

    public User(String id, String title, String description) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
