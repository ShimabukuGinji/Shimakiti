package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * コメント情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface CommentsRepository extends JpaRepository<Comments, Integer> {
}