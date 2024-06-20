package com.example.shimakiti.repository;


import com.example.shimakiti.entity.Bookmarks;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmarks, Integer> {
    List<Bookmarks> findByUser(User user);
    boolean existsByPostAndUser(Posts post, User user);
    void deleteByPostAndUser(Posts post, User user);
}