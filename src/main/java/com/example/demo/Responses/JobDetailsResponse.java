package com.example.demo.Responses;

import com.example.demo.Entities.Skills;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobDetailsResponse {
    private int jobid;
    private int recruiterid;
    private List<Skills> skill;
    private String title,discription,location;
    private float matchpercentage;

    public JobDetailsResponse(int jobid,List<Skills> skill, int recruiterid, String title, String discription, String location, float matchpercentage) {
        this.jobid = jobid;
        this.skill=skill;
        this.recruiterid = recruiterid;
        this.title = title;
        this.discription = discription;
        this.location = location;
        this.matchpercentage = matchpercentage;
    }

    public JobDetailsResponse() {
    }

    public List<Skills> getSkill() {
        return skill;
    }

    public void setSkill(List<Skills> skill) {
        this.skill = skill;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getMatchpercentage() {
        return matchpercentage;
    }

    public void setMatchpercentage(float matchpercentage) {
        this.matchpercentage = matchpercentage;
    }
}
