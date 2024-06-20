package com.example.shimakiti.service;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Cities;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.CategoriesRepository;

import com.example.shimakiti.repository.CityRepository;


import com.example.shimakiti.repository.PostRepository;
import com.example.shimakiti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ShimaService{

    @Autowired
    private PostRepository iShimaRepository;

    @Autowired
    private CategoriesRepository iCategoryRepository;

    @Autowired
    private CityRepository iCityRepository;

    @Autowired
    private UserRepository userRepository;



    public List<Posts> findAll(){
        return iShimaRepository.findAll();
    }

    public List<Categories> findCategory(){
        return iCategoryRepository.findAll();
    }

    public List<Cities> findCity(){
        return iCityRepository.findAll();
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findByIdUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public Categories findById(Integer id){
        return iCategoryRepository.findById(id).orElse(null);
    }

    //カテゴリーでPostを探す
    public List<Posts> findByCategoryPosts(Categories categories){
        return iShimaRepository.findByCategories(categories);
    }






}