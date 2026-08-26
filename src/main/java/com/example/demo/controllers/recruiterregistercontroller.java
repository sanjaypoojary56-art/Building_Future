package com.example.demo.controllers;

import com.example.demo.RecruiterApplications;
import com.example.demo.Repositories.ReappRepo;

import com.example.demo.Entities.Users;
import com.example.demo.Repositories.Repository1;
import com.example.demo.services.RecruiterRegisterController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class recruiterregistercontroller {
   @Autowired
   private RecruiterRegisterController rrs;
    @PostMapping("/recruiter-register")
    public String handlerequest(@RequestParam String email,@RequestParam String password,@RequestParam MultipartFile companyDocument)throws IOException
    {

        return rrs.recruiterregister(email,password,companyDocument);
    }
}
