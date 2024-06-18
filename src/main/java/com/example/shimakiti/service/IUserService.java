package com.example.shimakiti.service;

import com.example.shimakiti.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    List<User> findAll();

}
