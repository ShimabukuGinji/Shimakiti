package com.example.shimakiti.Service;

import com.example.shimakiti.Repository.UsersRepository;
import com.example.shimakiti.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    public List<Users> fingAll(){
        return usersRepository.findAll();
    }
}
