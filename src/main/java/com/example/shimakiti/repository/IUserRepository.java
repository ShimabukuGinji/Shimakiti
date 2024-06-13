package com.example.shimakiti.repository;

import com.example.shimakiti.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserRepository {
    List<User> findAll();

}
