package com.example.WebApp.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
}
