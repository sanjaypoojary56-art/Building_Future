package com.example.demo;

import jakarta.persistence.*;

@Entity
public class RecruiterApplications {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String email;
    private String name;
    private String password;
    @Lob
    private byte[] companyDocument;

    public RecruiterApplications( String email,  String password,byte[] companyDocument) {

        this.email = email;

        this.password = password;
        this.companyDocument=companyDocument;
    }

    public RecruiterApplications() {
    }


    public byte[] getCompanyDocument()
    {
        return this.companyDocument;
    }
    public void setCompanyDocument(byte[] b)
    {
        this.companyDocument=b;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
