package com.example.demo.services;

import com.example.demo.ChatRequests.*;
import com.example.demo.Entities.Applied;
import com.example.demo.Entities.Jobs;
import com.example.demo.Entities.Skills;
import com.example.demo.Entities.Users;
import com.example.demo.Repositories.Repo1;
import com.example.demo.Repositories.Repo2;
import com.example.demo.Repositories.Repo5;
import com.example.demo.Repositories.Repository;
import com.example.demo.Responses.AIResponse;
import com.example.demo.Responses.ResponseToReactFromAi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AIChatService {
    @Autowired
    private Repo2 r2;
    @Autowired
    private Repository repo;
    @Autowired
    private Repo1 r1;
    @Autowired
    private Repo5 r5;
    @Autowired
    private ApplicationService as;
    public ResponseToReactFromAi senddata(AIResponse response)
    {
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        String email=auth.getName();
        Users u=repo.findByEmail(email);
        String intent=response.getIntent();
        JobParameters jobparameters=response.getJobparameters();
        AppliedParameters appliedParameters=response.getAppliedParameters();
        String message=response.getMessage();
        List<Integer> id=appliedParameters.getId();
        List<User> user=appliedParameters.getUser();
        List<Job> job=appliedParameters.getJob();
        List<Integer> jobid=jobparameters.getJobid();
        List<Skill> skill=jobparameters.getSkill();
        List<String> title=jobparameters.getTitle();
        List<String> discription=jobparameters.getDiscription();
        List<String> location=jobparameters.getLocation();

        if(intent.equals("SEARCH_JOBS")) {

            List<Jobs> jobs=new ArrayList<>();
            if(jobid!=null)
            {
                jobs.addAll(r1.findAllById(jobid));
            }
            if(title!=null)
            {
                List<Jobs> j=r1.findAll();
                for(Jobs j1:j)
                {
                    if(title.contains(j1.getTitle()))
                    {
                        jobs.add(j1);
                    }
                }
            }
            if(location!=null)
            {
                List<Jobs> j=r1.findAll();
                for(Jobs j1:j)
                {
                    if(location.contains(j1.getLocation()))
                    {
                        jobs.add(j1);
                    }
                }
            }
            if(skill!=null)
            {
                List<Jobs> j=r1.findAll();
                for(Jobs j1:j)
                {
                    for(Skills s:j1.getSkill())
                    {
                        if(skill.contains(SkillsToSkill(s)))
                        {
                            jobs.add(j1);
                            break;
                        }
                    }
                }
            }

            return new ResponseToReactFromAi("JOBS",response.getMessage(),makeUnique(jobs),null);

        }
        else if("SEARCH_JOB_MYSKILLS".equalsIgnoreCase(response.getIntent()))
        {
            List<Skills> skl=u.getSkill();
            List<Jobs> j=new ArrayList<>();
            if(skl!=null)
            {
                System.out.println("IT working here");
                List<Jobs> j6=r1.findAll();
                for(Jobs j1:j6)
                {
                    System.out.println("IT working3 here");
                    for(Skills s:j1.getSkill())
                    {

                        System.out.println(s.getName());
                        if(skl.contains(s))
                        {
                            System.out.println(s.getName());
                            j.add(j1);
                            break;
                        }
                    }
                }
            }
            System.out.println("IT wor1king here");
            return new ResponseToReactFromAi("JOBS",response.getMessage(),makeUnique(j),null);
        }
        else if(intent.equals("APPLY_JOB"))
        {
            for(Integer jid:jobid)
            {
                as.apply(jid,email);
            }
            return new ResponseToReactFromAi("GENERAL","APPLICED SUCCESSFULLY",null,null);
        }
        else if(intent.equals("MY_APPLICATIONS"))
        {
            List<Applied> gh=new ArrayList<>();

            if("ROLE_STUDENT".equals(auth.getAuthorities().stream().findFirst().map(GrantedAuthority::getAuthority).orElseThrow()))
            {

                List<Applied> a=u.getApp();
                return new ResponseToReactFromAi("APPLICATIONS",response.getMessage(),null,a);
            }
            else {
                List<Applied> d=r5.findAll();
                for(Applied ap:d) {
                    if (u.getUserid() ==ap.getJob().getUs().getUserid())
                    {
                        gh.add(ap);
                    }
                }
                return new ResponseToReactFromAi("APPLICATIONS",response.getMessage(),null,gh);
            }
        }
        else if(intent.equals("CHECK_APPLICATION_STATUS")) {
            List<Jobs> n = new ArrayList<>();
            if ("ROLE_STUDENT".equals(auth.getAuthorities().stream().findFirst().map(GrantedAuthority::getAuthority).orElseThrow())) {
                List<Jobs> jobsforstatuscheck = new ArrayList<>();
                List<Jobs> jobstatus = new ArrayList<>();
                List<Applied> formatch = new ArrayList<>();
                List<Applied> as = r5.findAllByUser(u);
                for (Applied apl : as) {
                    jobsforstatuscheck.add(apl.getJob());

                }
                if (jobid != null) {
                    jobstatus.addAll(r1.findAllById(jobid));
                }
                if (title != null) {
                    List<Jobs> j = r1.findAll();
                    for (Jobs j1 : j) {
                        if (title.contains(j1.getTitle())) {
                            jobstatus.add(j1);
                        }
                    }
                }
                if (location != null) {
                    List<Jobs> j = r1.findAll();
                    for (Jobs j1 : j) {
                        if (location.contains(j1.getLocation())) {
                            jobstatus.add(j1);
                        }
                    }
                }
                if (skill != null) {
                    List<Jobs> j = r1.findAll();
                    for (Jobs j1 : j) {
                        for (Skills s : j1.getSkill()) {
                            if (skill.contains(SkillsToSkill(s))) {
                                jobstatus.add(j1);
                                break;
                            }
                        }
                    }
                }
                for (Applied f : as) {
                    if (jobstatus.contains(f.getJob())) {
                        formatch.add(f);
                    }
                }
                if (formatch.isEmpty()) {
                    response.setMessage("You didn't applied for this job");
                } else {
                    StringBuilder msgg = new StringBuilder("We found matches for" + formatch.size() + " jobs and status are ");
                    for (Applied ad : formatch) {
                        msgg.append("Jobid:").append(ad.getJob().getJobid()).append(" Title:").append(ad.getJob().getTitle()).append(" Status:").append(ad.getStatus());
                    }
                    response.setMessage(msgg.toString());
                }
                if (message.equalsIgnoreCase("SEARCH_WITHOUT_PARAMETERS")) {
                    List<Applied> os = r5.findAllByUser(u);
                    StringBuilder msgg = new StringBuilder("You are applied for " + os.size() + " jobs and status are ");
                    for (Applied ad : os) {
                        msgg.append("Jobid:").append(ad.getJob().getJobid()).append(" Title:").append(ad.getJob().getTitle()).append(" Status:").append(ad.getStatus());
                    }
                    response.setMessage(msgg.toString());
                }

                return new ResponseToReactFromAi("GENERAL", response.getMessage(), makeUnique(n), null);

            }


            else{
                response.setMessage("See your Dashboard for details");
                return new ResponseToReactFromAi("GENERAL", response.getMessage(), null, null);
            }

        }
        else if(intent.equals("SKILL_RECOMENDATIONS") || intent.equalsIgnoreCase("SKILL_GAP") && "ROLE_STUDENT".equals(auth.getAuthorities().stream().findFirst().map(GrantedAuthority::getAuthority).orElseThrow())) {
            System.out.println("HIIIII");
            List<Jobs> jobs = new ArrayList<>();
            if (!jobid.isEmpty()) {
                jobs.addAll(r1.findAllById(jobid));
                System.out.println("HIII1II");
            }
            else if (!title.isEmpty()) {
                System.out.println("HIII2II");
                List<Jobs> j = r1.findAll();
                for (Jobs j1 : j) {
                    System.out.println("dshd"+j1.getTitle());
                    if (title.contains(j1.getTitle())) {
                        jobs.add(j1);
                    }
                }
            }
            else {
                jobs=r1.findAll();
                System.out.println("HIII3II");
            }
            System.out.println("HIIIII");
            jobs = makeUnique(jobs);
            Set<String> sk = new HashSet<>();
            System.out.println("HIIIII"+jobs);
            for (Jobs j : jobs) {
                if (compareskill(u.getSkill(), j.getSkill()) > 75.0) {
                    for (Skills s : j.getSkill()) {
                        sk.add(s.getName());
                    }
                }
            }
            List<Skills> jk=u.getSkill();
            Set<String> kl=sk;
            sk.clear();
            for(Skills hj:jk)
            {
                if(!kl.contains(hj.getName()))
                {
                    sk.add(hj.getName());
                }
            }
            if (!sk.isEmpty()) {
                if (sk.size() == 1)
                {
                    for (String s : sk)
                    {
                        response.setMessage("There is one Skill That you can learn, " + s + " ");
                    }
                }
                else {
                    StringBuilder msg = new StringBuilder("There are " + sk.size() + " Skills You can learn They Are ");

                    for (String s : sk) {
                        msg.append(s).append(", ");
                    }
                    response.setMessage(String.valueOf(msg));
                }
            }
            System.out.println("HIIfdgdfgIII");
            return new ResponseToReactFromAi("GENERAL",response.getMessage(),null,null);
        }

        else if(intent.equals("TEXT")){
            return new ResponseToReactFromAi("GENERAL",response.getMessage(),null,null);

        }
        else {
            response.setMessage("AI Can Handle Some Specific Requests Only For Extra Information Visite Webpage");
            return new ResponseToReactFromAi("GENERAL",response.getMessage(),null,null);
        }
    }
    public Job convertJobsToJob(Jobs job)
    {
        return new Job(job.getJobid(),job.getTitle(),job.getDiscription(),job.getLocation(),job.getSkill());
    }
    public List<Jobs> makeUnique(List<Jobs> job)
    {
        List<Jobs> listjob=new ArrayList<>();
        List<Integer> visited=new ArrayList<>();
        for(Jobs j:job)
        {
            System.out.print(j.getJobid());
            if(!visited.contains(j.getJobid()))
            {
                visited.add(j.getJobid());
                listjob.add(j);
            }
        }
        return listjob;
    }
    public float compareskill(List<Skills> s1,List<Skills> s2)
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
        return (float)count/(s2.size())*100;
    }
    public Skill SkillsToSkill(Skills sk)
    {
        return new Skill(sk.getSkillid(),sk.getName());
    }
}
