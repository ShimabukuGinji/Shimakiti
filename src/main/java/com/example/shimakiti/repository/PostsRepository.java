package com.example.shimakiti.repository;

import com.example.shimakiti.entity.PostInfo;
import com.example.shimakiti.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 投稿情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface PostsRepository extends JpaRepository<Posts, Integer> {
}