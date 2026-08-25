package com.example.demo.ChatRequests;

import java.util.List;
import com.example.demo.ChatRequests.User;
public class AppliedParameters {
    private List<Integer> id;
    private List<User> user;
    private List<Job> job;

    public AppliedParameters() {
    }

    public AppliedParameters(List<Integer> id, List<User> user, List<Job> job) {
        this.id = id;
        this.user = user;
        this.job = job;
    }

    public List<Integer> getId() {
        return id;
    }

    public void setId(List<Integer> id) {
        this.id = id;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Job> getJob() {
        return job;
    }

    public void setJob(List<Job> job) {
        this.job = job;
    }
}
