package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {


}