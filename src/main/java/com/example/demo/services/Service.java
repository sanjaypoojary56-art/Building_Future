package com.example.demo.services;

import com.example.demo.Repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository rep;
}
