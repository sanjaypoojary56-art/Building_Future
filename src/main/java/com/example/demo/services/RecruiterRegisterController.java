package com.example.demo.services;

import com.example.demo.Entities.Users;
import com.example.demo.RecruiterApplications;
import com.example.demo.Repositories.ReappRepo;
import com.example.demo.Repositories.Repository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RecruiterRegisterController {
    @Autowired
    private Repository1 repo;
    @Autowired
    private ReappRepo rsp;

    public String recruiterregister(String email, String password, MultipartFile companyDocument) {
        Users u=repo.findByEmail(email);
        if(u==null)
        {
            try {
                RecruiterApplications ap = new RecruiterApplications(email, password, companyDocument.getBytes());
                rsp.save(ap);
            }
            catch(Exception e)
            {
                return e.getMessage();
            }
            return "Submitted for approval";
        }
        else
        {
            return "User already Exists";
        }
    }
}
