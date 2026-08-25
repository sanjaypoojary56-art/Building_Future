package com.example.demo.controllers;

import com.example.demo.ChatRequests.DashboardRequest;
import com.example.demo.Entities.Jobs;
import com.example.demo.Repositories.Repo1;
import com.example.demo.Repositories.Repo2;

import com.example.demo.Entities.Skills;
import com.example.demo.Entities.Users;
import com.example.demo.Responses.Jobresponse;
import com.example.demo.services.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class dashboardcontroller {
    private DashboardService dbs;
    @RequestMapping("/dashboard")
    @PreAuthorize("hasRole('STUDENT')")
    public DashboardRequest show(Authentication authentication)
    {
        return dbs.showdashboard();
    }

}
