package com.example.shimakiti.service;

import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

}
