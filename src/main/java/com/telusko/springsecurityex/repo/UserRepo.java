package com.telusko.springsecurityex.repo;

import com.telusko.springsecurityex.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer> {

    Users findByUsername(String username);
}
