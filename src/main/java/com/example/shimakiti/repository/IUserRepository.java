package com.example.shimakiti.repository;

import com.example.shimakiti.entity.User;

import java.util.List;


public interface IUserRepository {
    List<User> findAll();

}
