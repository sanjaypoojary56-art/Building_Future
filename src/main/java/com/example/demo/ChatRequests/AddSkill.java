package com.example.demo.ChatRequests;

import com.example.demo.Entities.Skills;

import java.util.List;

public class AddSkill {
    private List<Skills> skills;

    public AddSkill(List<Skills> skills) {
        this.skills = skills;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public AddSkill() {
    }


}
