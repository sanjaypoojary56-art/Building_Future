package com.example.demo.Responses;

import org.springframework.stereotype.Component;


public class logres {
    private String token;
    private String role;


    public logres() {
    }

    public logres(String token, String role) {
        this.token = token;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
