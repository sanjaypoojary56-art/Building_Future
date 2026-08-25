package com.example.demo.controllers;

import com.example.demo.Responses.JobDetailsResponse;
import com.example.demo.Entities.Jobs;
import com.example.demo.Repositories.Repo1;
import com.example.demo.Entities.Skills;
import com.example.demo.Entities.Users;
import com.example.demo.services.AlljobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class alljobs {
    @Autowired
    private AlljobsService ajs;
    @GetMapping("/jobs")
    public List<Jobs> getJobs()
    {
        return ajs.getalljobs();
    }
    @GetMapping("/jobs/{jobid}")
    public  JobDetailsResponse getJobs(@PathVariable int jobid)
    {
        return ajs.details(jobid);
    }

}
