package com.example.demo.services;

import com.example.demo.ChatRequests.editrequest;
import com.example.demo.Entities.Users;
import com.example.demo.Repositories.Repo2;
import com.example.demo.Repositories.Repository1;
import com.example.demo.Responses.editprofileresponse;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EditprofileService {
    @Autowired
    private Repository1 repo;
    @Autowired
    private Repo2 rp;
    public String editusersprofile(editrequest ed) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String email=authentication.getName();
        System.out.println("Array"+ed.getSkillIds()[0]);
        Users user=repo.findByEmail(email);
        System.out.println("Array"+ed.getSkillIds()[0]);
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i:ed.getSkillIds())
        {
            arr.add(i);
        }
        user.setSkill(rp.findAllById(arr));
        System.out.println("Array"+ed.getSkillIds()[0]);
        user.setEmail(ed.getEmail());
        user.setName(ed.getName());
        repo.save(user);
        return "OK";
    }

    public editprofileresponse showhisprofile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        System.out.println(email);
        Users user = repo.findByEmail(email);
        return new editprofileresponse(user.getName(),user.getEmail(),rp.findAll(),user.getSkill());
    }
}
