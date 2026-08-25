package com.example.demo.ChatRequests;

import org.springframework.stereotype.Component;


public class editrequest {
    private String email;
    private String name;
    private int[] skillIds;

    public editrequest() {
    }

    public editrequest(String email, String name, int[] skillids) {
        this.email = email;
        this.name = name;
        this.skillIds = skillids;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getSkillIds() {
        return skillIds;
    }

    public void setSkillIds(int[] skillids) {
        this.skillIds = skillids;
    }
}
