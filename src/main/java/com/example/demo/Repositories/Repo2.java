package com.example.demo.Repositories;

import com.example.demo.Entities.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo2 extends JpaRepository<Skills,Integer> {



}
