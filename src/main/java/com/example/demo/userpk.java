package com.example.demo;

import jakarta.persistence.Id;
import org.springframework.stereotype.Component;

@Component
public class userpk {
    private int userid;
    private int skillid;

    public userpk() {
    }

    public userpk(int userid, int skillid) {
        this.userid = userid;
        this.skillid = skillid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getSkillid() {
        return skillid;
    }

    public void setSkillid(int skillid) {
        this.skillid = skillid;
    }
}
