package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;


@Entity
public class Applied {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
    @JsonBackReference
   @ManyToOne
   @JoinColumn(name="userid")
   private Users user;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="jobid")
    private Jobs job;
   private String status;
    public Applied() {
    }

    public Applied( Users user, Jobs job, String status) {

        this.user = user;
        this.job = job;
        this.status = status;
    }



    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Jobs getJob() {
        return job;
    }

    public void setJob(Jobs job) {
        this.job = job;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
