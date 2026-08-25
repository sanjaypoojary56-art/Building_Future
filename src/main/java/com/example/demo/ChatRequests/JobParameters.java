package com.example.demo.ChatRequests;

import java.util.List;

public class JobParameters {
    private List<Integer> jobid;
    private List<Skill> skill;
    private List<String> title;
    private List<String> discription;
    private List<String> location;

    public JobParameters(List<Integer> jobid, List<Skill> skill, List<String> title, List<String> discription, List<String> location) {
        this.jobid = jobid;
        this.skill = skill;
        this.title = title;
        this.discription = discription;
        this.location = location;
    }

    public List<Integer> getJobid() {
        return jobid;
    }

    public void setJobid(List<Integer> jobid) {
        this.jobid = jobid;
    }

    public List<Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Skill> skill) {
        this.skill = skill;
    }

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    public List<String> getDiscription() {
        return discription;
    }

    public void setDiscription(List<String> discription) {
        this.discription = discription;
    }

    public List<String> getLocation() {
        return location;
    }

    public void setLocation(List<String> location) {
        this.location = location;
    }
}
