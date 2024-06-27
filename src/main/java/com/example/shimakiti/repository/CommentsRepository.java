package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Bookmarks;
import com.example.shimakiti.entity.Comments;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * コメント情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface CommentsRepository extends JpaRepository<Comments, Integer> {
    List<Comments> findByPost(Posts posts);

    List<Comments> findByUser(User user);
}