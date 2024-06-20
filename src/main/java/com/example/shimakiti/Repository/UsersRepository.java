package com.example.shimakiti.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.shimakiti.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    List<Users> findAll();
}
