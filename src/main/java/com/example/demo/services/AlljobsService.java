package com.example.demo.services;

import com.example.demo.Entities.Jobs;
import com.example.demo.Entities.Skills;
import com.example.demo.Entities.Users;
import com.example.demo.Repositories.Repo1;
import com.example.demo.Repositories.Repository1;
import com.example.demo.Responses.JobDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlljobsService {
    @Autowired
    private Repo1 rp;
    @Autowired
    private Repository1 rep;

    public JobDetailsResponse details(int jobid) {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Jobs job= rp.findById(jobid).orElseThrow(()->new RuntimeException("JOB NOT FOUND"));
        Users user=rep.findByEmail(auth.getName());
        return new JobDetailsResponse(job.getJobid(),job.getSkill(),job.getUs().getUserid(),job.getTitle(),job.getDiscription(),job.getLocation(),compareskill(user.getSkill(),job.getSkill()));
    }

    public List<Jobs> getalljobs() {
        return rp.findAll();
    }
    private static float compareskill(List<Skills> s1, List<Skills> s2) {
        int count = 0;
        for (Skills d : s1) {
            for (Skills f : s2) {
                if (d.getSkillid() == f.getSkillid()) {
                    count++;
                }
            }
        }
        return (float) count / (s1.size()) * 100;
    }
}
