package com.example.demo.Entities;

import com.example.demo.Entities.Applied;
import com.example.demo.Entities.Jobs;
import com.example.demo.Entities.Skills;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Component
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    private String name,email,password;
    @ManyToMany
    @JoinTable(name="user_skills",
            joinColumns = @JoinColumn(name="userid"),
            inverseJoinColumns = @JoinColumn(name="skillid"))
    private List<Skills> skill;
    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Applied> app;
    @JsonManagedReference
    @OneToMany(mappedBy = "us")
    private List<Jobs> jobs;

    public Users(int userid, String name, String email, String password, List<Skills> skill, List<Applied> app, List<Jobs> jobs, String role) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.skill = skill;
        this.app = app;
        this.jobs = jobs;
        this.role = role;
    }

    public List<Applied> getApp() {
        return app;
    }

    public void setApp(List<Applied> app) {
        this.app = app;
    }

    public List<Jobs> getJobs() {
        return jobs;
    }

    public Users(int userid, String name, String email, String password, List<Skills> skill, List<Jobs> jobs, String role) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.skill = skill;
        this.jobs = jobs;
        this.role = role;
    }

    public void setJobs(List<Jobs> jobs) {
        this.jobs = jobs;
    }

    public Users(String role, List<Skills> skill, String password, String email, String name) {

        this.role = role;
        this.skill = skill;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public Users(String email, String password, String role,String name) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.name=name;
    }

    public List<Skills> getSkill() {
        return skill;
    }

    public void setSkill(List<Skills> skill) {
        this.skill = skill;
    }

    public Users() {
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String role;
}
