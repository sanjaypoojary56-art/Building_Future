package com.example.demo.Responses;

import com.example.demo.Entities.Jobs;
import com.example.demo.Entities.Users;
import org.springframework.stereotype.Component;

@Component
public class applicatonresponse {
    private int id;
    private Users user;
    private Jobs job;
    private String status;

    public applicatonresponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public applicatonresponse(int id, Users user, Jobs job, String status) {
        this.id = id;
        this.user = user;
        this.job = job;
        this.status = status;
    }
}
