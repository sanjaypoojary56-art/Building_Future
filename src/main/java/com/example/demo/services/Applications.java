package com.example.demo.services;

import com.example.demo.ChatRequests.Job;
import com.example.demo.ChatRequests.User;

public class Applications {
    private int id;
    private User user;
    private Job job;

    public Applications(int id, User user, Job job) {
        this.id = id;
        this.user = user;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
