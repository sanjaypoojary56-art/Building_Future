package com.example.demo.LoginRequest;

public class recruiterregisterRequest {
    private String email;
    private String password;
    private byte[] companyDocument;
    private String status;

    public recruiterregisterRequest() {
    }

    public recruiterregisterRequest(String email, String password, byte[] companyDocument, String status) {
        this.email = email;
        this.password = password;
        this.companyDocument = companyDocument;
        this.status = status;
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

    public byte[] getCompanyDocument() {
        return companyDocument;
    }

    public void setCompanyDocument(byte[] companyDocument) {
        this.companyDocument = companyDocument;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
