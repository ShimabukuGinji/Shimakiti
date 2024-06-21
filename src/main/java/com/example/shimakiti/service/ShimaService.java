package com.example.shimakiti.service;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Cities;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.ICategoryRepository;
import com.example.shimakiti.repository.ICityRepository;
import com.example.shimakiti.repository.IShimaRepository;

import com.example.shimakiti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
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

    public User findByIdUser(String username) {
        return userRepository.findById(username).orElse(null);
    }

    public Categories findById(Long id){
        return iCategoryRepository.findById(id).orElse(null);
    }

    //カテゴリーでPostを探す
    public List<Posts> findByCategoryPosts(Categories categories){
        return iShimaRepository.findByCategories(categories);
    }

    public Categories updateCategory(Long id, Categories categoryDetails) {
        Categories category = iCategoryRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("","Category not found",""));
        category.setName(categoryDetails.getName());
        return iCategoryRepository.save(category);
    }

    public Categories addCategory(Categories category) {
        return iCategoryRepository.save(category);
    }






}
