package com.example.demo.Entities;

import com.example.demo.Entities.Applied;
import com.example.demo.Entities.Skills;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobid;


    private String title, discription, location;
    @ManyToMany
    @JoinTable(name = "job_skills",
            joinColumns = @JoinColumn(name = "jobid"),
            inverseJoinColumns = @JoinColumn(name = "skillid"))
    private List<Skills> skill;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userid")
    private Users us;
    @JsonManagedReference
    @OneToMany(mappedBy = "job")
    private List<Applied> app;

    public List<Applied> getApp() {
        return app;
    }

    public void setApp(List<Applied> app) {
        this.app = app;
    }

    public Jobs() {
    }

    public Jobs(String title, String discription, String location, List<Skills> skill, Users us) {
        this.title = title;
        this.discription = discription;
        this.location = location;
        this.skill = skill;
        this.us = us;
    }

    public Jobs(int jobid, String title, String discription, String location, List<Skills> skill, Users us, List<Applied> app) {
        this.jobid = jobid;
        this.title = title;
        this.discription = discription;
        this.location = location;
        this.skill = skill;
        this.us = us;
        this.app = app;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
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

    public List<Skills> getSkill() {
        return skill;
    }

    public void setSkill(List<Skills> skill) {
        this.skill = skill;
    }

    public Users getUs() {
        return us;
    }

    public void setUs(Users us) {
        this.us = us;
    }
}

