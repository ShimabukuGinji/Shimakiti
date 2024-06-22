package com.example.shimakiti.service;

import com.example.shimakiti.repository.CategoriesRepository;
import com.example.shimakiti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;

import java.util.List;
//
@Service
public class CategoryService {

    @Autowired
    CategoriesRepository categoriesRepository;

    @Autowired
    UserRepository userRepository;


    public Categories findById(Integer id){
        return categoriesRepository.findById(id).orElse(null);
    }

    //カテゴリーでPostを探す
    public List<Posts> findByCategoryPosts(Categories categories){
        return categoriesRepository.findByCategories(categories);
    }

    public Categories updateCategory(Integer id, Categories categoryDetails) {
        Categories category = categoriesRepository.findById(id).orElseThrow(() -> new InvalidConfigurationPropertyValueException("","Category not found",""));
        category.setName(categoryDetails.getName());
        return categoriesRepository.save(category);
    }

    public Categories addCategory(Categories category) {
        return categoriesRepository.save(category);
    }
    public User findByUserName(String username){

        return userRepository.findById(Integer.valueOf(username)).orElse(null);
    }

    public List<Categories> findCategory(){
        return categoriesRepository.findAll();
    }
}
