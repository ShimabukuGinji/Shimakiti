package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Cities;
import com.example.shimakiti.entity.Comments;
import com.example.shimakiti.entity.Likes;
import com.example.shimakiti.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * コメント情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface CommentsRepository extends JpaRepository<Comments, Integer> {

    List<Comments> findByPosts(Posts posts);
}