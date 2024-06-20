package com.example.shimakiti.Repository;

import com.example.shimakiti.entity.Notices;
import com.example.shimakiti.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> postsJoinCategory();
}
