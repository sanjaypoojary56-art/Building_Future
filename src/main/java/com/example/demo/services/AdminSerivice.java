package com.example.demo.services;

import com.example.demo.Entities.Users;
import com.example.demo.RecruiterApplications;
import com.example.demo.Repositories.ReappRepo;
import com.example.demo.Repositories.Repository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSerivice {
    @Autowired
    private ReappRepo f;
    @Autowired
    private Repository1 g;

    public List<RecruiterApplications> Allapk() {
        return f.findAll();
    }

    public String allrapk(Integer applicationId) {
        RecruiterApplications r=f.findById(applicationId).orElseThrow();
        Users u=new Users(r.getEmail(),r.getPassword(),"RECRUITER","");
        g.save(u);
        f.delete(r);
        return "Successful";
    }

    public String rejectapk(Integer applicationId) {
        RecruiterApplications r=f.findById(applicationId).orElseThrow();
        f.delete(r);
        return "Rejected";
    }

    public ResponseEntity<byte[]> showdoc(Integer applicationId) {
        RecruiterApplications r=f.findById(applicationId).orElseThrow();
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(r.getCompanyDocument());
    }
}
