package com.example.demo;

import com.example.demo.Entities.Skills;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class addJob {
    private String title;
    private String description;
    private String location;
    private List<Skills> skill;

    public addJob() {
    }

    public addJob(String title, String description, String location, List<Skills> skill) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.skill = skill;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Skills> getSkill() {
        return skill;
    }

    public void setSkill(List<Skills> skill) {
        this.skill = skill;
    }
}
