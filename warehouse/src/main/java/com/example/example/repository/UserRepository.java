package com.example.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.example.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

