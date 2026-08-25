package com.example.demo.Repositories;

import com.example.demo.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository1 extends JpaRepository<Users,Integer> {
 public Users findByEmail(String email);
}
