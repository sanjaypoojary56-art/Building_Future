package com.example.demo.Responses;

import com.example.demo.Entities.Skills;

import java.util.List;
import com.example.demo.Entities.Skills;

public class editprofileresponse {
    private String name;
    private String email;
    private List<Skills> skills;
    private List<Skills> existingSkills;

    public editprofileresponse() {
    }

    public editprofileresponse(String name, String email, List<Skills> skills, List<Skills> existingSkills) {
        this.name = name;
        this.email = email;
        this.skills = skills;
        this.existingSkills = existingSkills;
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

    public List<Skills> getSkills() {
        return skills;
    }

    public void setSkills(List<Skills> skills) {
        this.skills = skills;
    }

    public List<Skills> getExistingSkills() {
        return existingSkills;
    }

    public void setExistingSkills(List<Skills> existingSkills) {
        this.existingSkills = existingSkills;
    }
}
