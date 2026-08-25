package com.example.demo.Repositories;

import com.example.demo.RecruiterApplications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReappRepo extends JpaRepository<RecruiterApplications,Integer> {
    public RecruiterApplications findByEmail(String email);


}
