package com.example.demo.controllers;

import com.example.demo.ChatRequests.RegisterRequest1;
import com.example.demo.Repositories.Repository;
import com.example.demo.Entities.Users;
import com.example.demo.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.ChatRequests.RegisterRequest1;

@RestController
public class registerController {
    @Autowired
    private RegisterService rs;
    @PostMapping("/register")
    public String register1(@RequestBody RegisterRequest1 k)
    {
       return rs.maderegis(k);
    }
}
