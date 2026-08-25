package com.example.demo.Responses;

import com.example.demo.ChatRequests.AppliedParameters;
import com.example.demo.ChatRequests.JobParameters;

public class AIResponse {
    private String intent;
    private JobParameters jobparameters;
    private AppliedParameters appliedParameters;
    private String message;

    public String getMessage() {
        return message;
    }

    public AIResponse(String intent, JobParameters jobparameters, AppliedParameters appliedParameters, String message) {
        this.intent = intent;
        this.jobparameters = jobparameters;
        this.appliedParameters = appliedParameters;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AppliedParameters getAppliedParameters() {
        return appliedParameters;
    }

    public void setAppliedParameters(AppliedParameters appliedParameters) {
        this.appliedParameters = appliedParameters;
    }


    public AIResponse() {
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public JobParameters getJobparameters() {
        return jobparameters;
    }

    public void setJobparameters(JobParameters jobparameters) {
        this.jobparameters = jobparameters;
    }
}
