package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Integer> {
}
