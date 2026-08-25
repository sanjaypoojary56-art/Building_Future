package com.example.demo.services;

import com.example.demo.ChatRequests.DashboardRequest;
import com.example.demo.Entities.Jobs;
import com.example.demo.Entities.Skills;
import com.example.demo.Entities.Users;
import com.example.demo.Repositories.Repo1;
import com.example.demo.Repositories.Repo2;
import com.example.demo.Repositories.Repository1;
import com.example.demo.Responses.Jobresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DashboardService {
    @Autowired
    private Repository1 repo;
    @Autowired
    private Repo2 rep;
    @Autowired
    private Repo1 r;
    public DashboardRequest showdashboard() {
        DashboardRequest dash;
         Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String email=authentication.getName();
        Users user=repo.findByEmail(email);
        List<Jobs> j=new ArrayList<>();
        List<Skills> f=rep.findAll();

        j.addAll(r.findAll());
        List<Skills> skill=user.getSkill();
        List<Jobresponse> js=new ArrayList<>();
        for(Jobs a:j)
        {
            if(compareskill(a.getSkill(), skill)>75.0) {
                js.add(new Jobresponse(a.getJobid(), a.getUs().getUserid(), a.getTitle(), a.getDiscription(), compareskill(a.getSkill(), skill)));
            }

        }
        dash=new DashboardRequest(user,js);
        return dash;
    }
    private static float compareskill(List<Skills> s1,List<Skills> s2)
    {
        int count=0;
        for(Skills d:s1)
        {
            for(Skills f:s2)
            {
                if(d.getSkillid()==f.getSkillid())
                {
                    count++;
                }
            }
        }
        return (float)count/(s1.size())*100;
    }
}
