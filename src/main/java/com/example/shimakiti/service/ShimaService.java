package com.example.shimakiti.service;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Cities;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.ICategoryRepository;
import com.example.shimakiti.repository.ICityRepository;
import com.example.shimakiti.repository.IShimaRepository;
//import com.example.shimakiti.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShimaService{

    @Autowired
    private IShimaRepository iShimaRepository;

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Autowired
    private ICityRepository iCityRepository;

    public List<Posts> findAll(){
        return iShimaRepository.findAll();
    }

    public List<Categories> findCategory(){
        return iCategoryRepository.findAll();
    }

    public List<Cities> findCity(){
        return iCityRepository.findAll();
    }

//    @Autowired
//    private IUserRepository userRepository;
//
//    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
//        User user = userRepository.findByLoginId(loginId);
//        if (user == null) {
//            throw new UsernameNotFoundException("ユーザーが見つかりません");
//        }
//        return org.springframework.security.core.userdetails.User.withUsername(user.getLoginId())
//                .password(user.getPassword())
//                .roles(user.getRole() == 1 ? "ADMIN" : "USER")
//                .build();
//    }


}
