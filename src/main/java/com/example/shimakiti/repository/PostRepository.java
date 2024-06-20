package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts, Integer> {


    List<Posts> findByCategories(Categories categories);

}
