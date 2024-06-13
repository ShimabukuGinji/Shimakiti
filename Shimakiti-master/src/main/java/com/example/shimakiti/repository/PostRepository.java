package com.example.shimakiti.repository;


import com.example.shimakiti.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
