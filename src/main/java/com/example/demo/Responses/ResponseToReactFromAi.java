package com.example.demo.Responses;

import com.example.demo.Entities.Applied;
import com.example.demo.Entities.Jobs;

import java.util.List;

public class ResponseToReactFromAi {
    private String type;
    private String message;
    private List<Jobs> jobs;
    private List<Applied> app;

    public ResponseToReactFromAi() {
    }

    public ResponseToReactFromAi(String type, String message, List<Jobs> jobs, List<Applied> app) {
        this.type = type;
        this.message = message;
        this.jobs = jobs;
        this.app = app;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Jobs> getJobs() {
        return jobs;
    }

    public void setJobs(List<Jobs> jobs) {
        this.jobs = jobs;
    }

    public List<Applied> getApp() {
        return app;
    }

    public void setApp(List<Applied> app) {
        this.app = app;
    }
}
