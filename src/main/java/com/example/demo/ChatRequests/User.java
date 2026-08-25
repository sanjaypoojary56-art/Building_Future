package com.example.demo.ChatRequests;

import com.example.demo.Entities.Skill;

import java.util.List;

public class User {
    private int userid;
    private String name,email,password;
    private List<Skill> skill;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    public User(int userid, String name, String email, String password, List<Skill> skill) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.skill = skill;
    }
}
