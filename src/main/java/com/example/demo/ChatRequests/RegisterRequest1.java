package com.example.demo.ChatRequests;

import org.springframework.stereotype.Component;

@Component
public class RegisterRequest1 {
    private String email;
    private String password;

    public RegisterRequest1() {
    }

    public RegisterRequest1(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
