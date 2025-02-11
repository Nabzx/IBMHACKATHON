package com.example.springboot.repo;

import com.example.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // You can define custom query methods if needed
    User findByUsername(String username);
    User findByEmail(String email);
}

