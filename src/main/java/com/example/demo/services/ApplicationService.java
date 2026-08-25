package com.example.demo.services;

import com.example.demo.Entities.Applied;
import com.example.demo.Entities.Jobs;
import com.example.demo.Entities.Users;
import com.example.demo.Repositories.Repo1;
import com.example.demo.Repositories.Repo5;
import com.example.demo.Repositories.Repository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    @Autowired
    private Repository1 repo;
    @Autowired
    private Repo1 rp;
    @Autowired
    private Repo5 r5;
    public String apply(int jobid,String email)
    {
        Users u=repo.findByEmail(email);
        Jobs j=rp.findById(jobid).orElseThrow();
        Applied ap=new Applied(u,j,"APPLIED");
        r5.save(ap);
        return "Applied Successfully";
    }

}
