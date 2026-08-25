package com.example.demo.controllers;

import com.example.demo.ChatRequests.editrequest;
import com.example.demo.Repositories.Repo2;

import com.example.demo.Entities.Users;
import com.example.demo.Responses.editprofileresponse;
import com.example.demo.services.EditprofileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import com.example.demo.Repositories.Repo2;
@RestController
public class EditProfileController {
    @Autowired
    private EditprofileService edps;
    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/profile")
    @PreAuthorize("hasRole('STUDENT')")
    public String editprofile(@RequestBody editrequest ed)
    {
        return edps.editusersprofile(ed);
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/profile")
    @PreAuthorize("hasRole('STUDENT')")
    public editprofileresponse provideprofile() {
        return edps.showhisprofile();
    }
}
