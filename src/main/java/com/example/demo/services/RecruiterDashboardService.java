package com.example.demo.services;

import com.example.demo.Entities.Applied;
import com.example.demo.Entities.Jobs;
import com.example.demo.Entities.Skills;
import com.example.demo.Entities.Users;
import com.example.demo.Repositories.Repo1;
import com.example.demo.Repositories.Repo2;
import com.example.demo.Repositories.Repo5;
import com.example.demo.Repositories.Repository1;
import com.example.demo.Responses.applicatonresponse;
import com.example.demo.addJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecruiterDashboardService {
    @Autowired
    private Repo5 r5;
    @Autowired
    private Repository1 repo;
    @Autowired
    private Repo1 r1;
    @Autowired
    private Repo2 r2;

    public List<applicatonresponse> giveresponse() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String email=authentication.getName();
        Users user=repo.findByEmail(email);
        List<Applied> ap=r5.findAll();
        List<applicatonresponse> app=new ArrayList<applicatonresponse>();
        for(Applied a:ap)
        {
            if(a.getJob().getUs().getUserid()==user.getUserid())
            {
                app.add(new applicatonresponse(a.getId(),a.getUser(),a.getJob(),a.getStatus()));
            }
        }
        return app;
    }
    public Applied changethestatus(int applicationid,String status)
    {
        Applied app=r5.findById(applicationid).orElseThrow();
        System.out.println("The status is :"+status+"The id ius:"+applicationid);
        app.setStatus(status);
        r5.save(app);
        return app;
    }
public List<Jobs> sendsomejobs()
    {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        String email=authentication.getName();
        Users u=repo.findByEmail(email);
        return u.getJobs();
    }
    public Jobs addnewjob(addJob add) {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        assert authentication != null;
        String email=authentication.getName();
        System.out.println(email);
        Users u=repo.findByEmail(email);
        System.out.println(u.getEmail());
        Jobs j=new Jobs(add.getTitle(),add.getDescription(),add.getLocation(),add.getSkill(),u);
        r1.save(j);
        return j;
    }

    public void deleteone(int jobid) {
        r1.delete(r1.findById(jobid).orElseThrow());
    }

    public List<Skills> provideallsk() {
        return r2.findAll();
    }
}
