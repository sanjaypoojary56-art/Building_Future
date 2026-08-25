package com.example.demo.Repositories;

import com.example.demo.Entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo1 extends JpaRepository<Jobs,Integer> {
public Jobs findAllByTitle(String title);
    public Jobs findAllByLocation(String location);


}
