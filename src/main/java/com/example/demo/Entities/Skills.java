package com.example.demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.stereotype.Component;


@Entity
public class Skills {
    @Id
    private int skillid;
    private String name;

    public Skills() {
    }

    public Skills(int skillid, String name) {
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
