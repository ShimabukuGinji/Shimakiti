package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Integer> {
}
