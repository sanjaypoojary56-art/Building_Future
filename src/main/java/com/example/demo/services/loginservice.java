package com.example.demo.services;

import com.example.demo.Entities.Users;
import com.example.demo.LoginRequest.LoginRequest;
import com.example.demo.Repositories.Repository1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.Responses.logres;

@Service
public class loginservice {
    @Autowired
    private Repository1 repo;
    @Autowired
    private JwtService jwts;
    public logres loguser(LoginRequest re) {
        Users user=repo.findByEmail(re.getUsername());
        if(user!=null&&user.getEmail().equals(re.getUsername())&&user.getPassword().equals(re.getPassword()))
        {


            String token=jwts.generateToken(user);
            return new logres(token,user.getRole());
        }
        else {

            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);

        }
    }
}
