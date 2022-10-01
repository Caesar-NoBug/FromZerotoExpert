package com.caesar.Domain;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private byte age;

    public User(){
        this.sex = "男";
        this.age = 18;
    }
}
