package com.example.demo.controllers;

import com.example.demo.*;
import com.example.demo.Entities.Applied;
import com.example.demo.Entities.Jobs;
import com.example.demo.Entities.Skills;
import com.example.demo.Entities.Users;
import com.example.demo.Repositories.Repo1;
import com.example.demo.Repositories.Repo2;
import com.example.demo.Repositories.Repo5;
import com.example.demo.Responses.applicatonresponse;
import com.example.demo.services.RecruiterDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecruiterDashboardController {
    @Autowired
    private RecruiterDashboardService rds;
    @GetMapping("/recruiter/applications")
    public List<applicatonresponse> recruiterdashboard()
    {
       return rds.giveresponse();

    }
    @GetMapping("/recruiter/jobs")
    public List<Jobs> sendJobs()
    {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String email=authentication.getName();
        Users u=repo.findByEmail(email);
        return u.getJobs();
    }
    @PutMapping("/recruiter/applications/{applicationid}/status/{status}")
    public Applied chnageStatus(@PathVariable int applicationid,@PathVariable String status)
    {
        Applied app=r5.findById(applicationid).orElseThrow();
        System.out.println("The status is :"+status+"The id ius:"+applicationid);
        app.setStatus(status);
        r5.save(app);
        return app;
    }
    @PostMapping("/recruiter/jobs")
    public Jobs addjob(@RequestBody addJob add)
    {
        return rds.addnewjob(add);
    }
    @DeleteMapping("/recruiter/jobs/{jobid}")
    public void deletejob(@PathVariable int jobid)
    {
           rds.deleteone(jobid);
    }
    @GetMapping("/recruiter/skill")
    public List<Skills> getallskill()
    {
        return rds.provideallsk();
    }
}
