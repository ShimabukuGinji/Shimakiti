package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Bookmarks;
import com.example.shimakiti.entity.Likes;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * いいね情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface LikesRepository extends JpaRepository<Likes, Integer> {
    List<Likes> findByPost(Posts posts);
    List<Likes> findByUser(User user);
    boolean existsByPostAndUser(Posts post, User user);
    Likes findByPostAndUser(Posts post, User user);
}