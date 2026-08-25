package com.example.demo.controllers;

import com.example.demo.services.ApplicationService;
import com.example.demo.Repositories.Repo1;
import com.example.demo.Repositories.Repo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @Autowired
    private ApplicationService as;
    @PostMapping("/jobs/{jobid}/apply")
    public String applyforjob(@PathVariable int jobid)
    {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String email=auth.getName();
        return as.apply(jobid,email);
    }
}
