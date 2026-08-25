package com.example.demo.controllers;

import com.example.demo.RecruiterApplications;
import com.example.demo.Repositories.ReappRepo;

import com.example.demo.Entities.Users;
import com.example.demo.services.AdminSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class admincontroller {
    @Autowired
    private AdminSerivice ads;
    @GetMapping("admin/recruiter-applications")
    @PreAuthorize("hasRole('ADMIN')")
    public List<RecruiterApplications> provide()
    {
        return ads.Allapk();
    }
    @GetMapping("/admin/recruiter-applications/{applicationId}/approve")
    @PreAuthorize("hasRole('ADMIN')")
    public String approvehim(@PathVariable Integer applicationId)
    {
      return ads.allrapk(applicationId);
    }
    @GetMapping("/admin/recruiter-applications/{applicationId}/reject")
    public String rejecthim(@PathVariable Integer applicationId)
    {
        return ads.rejectapk(applicationId);
    }
    @GetMapping("/admin/recruiter-applications/{applicationId}/document")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<byte[]> getDocument(@PathVariable Integer applicationId)
    {
       return ads.showdoc(applicationId);
    }
}
