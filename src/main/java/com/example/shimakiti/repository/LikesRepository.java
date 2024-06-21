package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Comments;
import com.example.shimakiti.entity.Likes;
import com.example.shimakiti.entity.Posts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * いいね情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface LikesRepository extends JpaRepository<Likes, Integer> {
    List<Likes> findByPosts(Posts posts);
}