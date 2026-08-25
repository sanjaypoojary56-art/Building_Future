package com.example.demo.controllers;

import com.example.demo.LoginRequest.LoginRequest;
import com.example.demo.Responses.logres;
import com.example.demo.services.loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class logincontroller {
    @Autowired
    private loginservice ls;
    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/login")
    public logres loginHandler(@RequestBody LoginRequest re)
    {
        return ls.loguser(re);
    }
}
