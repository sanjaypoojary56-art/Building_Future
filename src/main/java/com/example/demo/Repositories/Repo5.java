package com.example.demo.Repositories;

import com.example.demo.Entities.Applied;
import com.example.demo.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Repo5 extends JpaRepository<Applied,Integer> {
    public List<Applied> findAllByUser(Users user);

}
