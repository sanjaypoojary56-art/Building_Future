package com.example.demo.ChatRequests;

public class Skill {
    private int skillid;
    private String name;

    public Skill(int skillid, String name) {
        this.skillid = skillid;
        this.name = name;
    }

    public int getSkillid() {
        return skillid;
    }

    public void setSkillid(int skillid) {
        this.skillid = skillid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
