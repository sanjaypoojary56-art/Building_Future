package com.example.demo.ChatRequests;

import com.example.demo.Entities.Users;
import com.example.demo.Responses.Jobresponse;

import java.util.List;

public class DashboardRequest {
    private Users user;
    private List<Jobresponse> job;

    public DashboardRequest(Users user, List<Jobresponse> job) {
        this.user = user;
        this.job = job;
    }

    public DashboardRequest() {
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Jobresponse> getJob() {
        return job;
    }

    public void setJob(List<Jobresponse> job) {
        this.job = job;
    }
}
