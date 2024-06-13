package com.example.shimakiti.repository;


import com.example.shimakiti.entity.Like;
import com.example.shimakiti.entity.Post;
import com.example.shimakiti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByPostAndUser(Post post, User user);
    void deleteByPostAndUser(Post post, User user);
}
