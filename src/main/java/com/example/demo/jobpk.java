package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class jobpk {
    int jobid1;
    int skillid1;

    public jobpk() {
    }

    public jobpk(int jobid1, int skillid1) {
        this.jobid1 = jobid1;
        this.skillid1 = skillid1;
    }

    public int getJobid1() {
        return jobid1;
    }

    public void setJobid1(int jobid1) {
        this.jobid1 = jobid1;
    }

    public int getSkillid1() {
        return skillid1;
    }

    public void setSkillid1(int skillid1) {
        this.skillid1 = skillid1;
    }
}
