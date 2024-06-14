package com.example.shimakiti.servise;

import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.IUserRepository;
import lombok.AllArgsConstructor;
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
