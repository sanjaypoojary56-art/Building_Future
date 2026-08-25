package com.example.demo.services;

import com.example.demo.ChatRequests.RegisterRequest1;
import com.example.demo.Entities.Users;
import com.example.demo.Repositories.Repository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private Repository1 h;

    public String maderegis(RegisterRequest1 k) {
        Users l=h.findByEmail(k.getEmail());
        System.out.println(k.getEmail());
        if(l!=null)
        {
            return "User already Exists";
        }
        else {
            if(k.getEmail().equals("sanjaypoojary56@gmail.com"))
            {
                h.save(new Users(k.getEmail(), k.getPassword(), "ADMIN", "Sanjay"));
                return "Login successful";
            }
            else {
                String name = k.getEmail().substring(0, k.getEmail().indexOf('@'));
                h.save(new Users(k.getEmail(), k.getPassword(), "STUDENT", name));
                return "Register Successful";
            }
        }
    }
}
