package com.example.demo.ChatRequests;

public class AIChatRequest {
    private String message;

    public AIChatRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
