package com.example.demo.Responses;

public class Jobresponse {
    private int jobid;
    private int recruiterid;
    private String title,discription;
    private float matchpercentage;



    public Jobresponse(int jobid, int recruiterid, String title, String discription, float matchpercentage) {
        this.jobid = jobid;
        this.recruiterid = recruiterid;
        this.title = title;
        this.discription = discription;
        this.matchpercentage = matchpercentage;
    }

    public int getJobid() {
        return jobid;
    }

    public void setJobid(int jobid) {
        this.jobid = jobid;
    }

    public int getRecruiterid() {
        return recruiterid;
    }

    public void setRecruiterid(int recruiterid) {
        this.recruiterid = recruiterid;
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

    public float getMatchpercentage() {
        return matchpercentage;
    }

    public void setMatchpercentage(float matchpercentage) {
        this.matchpercentage = matchpercentage;
    }
}
