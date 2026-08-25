package com.example.demo.ChatRequests;

import com.example.demo.Entities.Skills;

import java.util.List;

public class Job {
    private Integer jobid;
    private String title, discription, location;
    private List<Skills> skill;

    public Job(Integer jobid, String title, String discription, String location, List<Skills> skill) {
        this.jobid = jobid;
        this.title = title;
        this.discription = discription;
        this.location = location;
        this.skill = skill;
    }

    public List<Skills> getSkill() {
        return skill;
    }

    public void setSkill(List<Skills> skill) {
        this.skill = skill;
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
