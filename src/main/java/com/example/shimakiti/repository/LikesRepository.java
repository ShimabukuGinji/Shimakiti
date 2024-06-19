package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * いいね情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface LikesRepository extends JpaRepository<Likes, Integer> {
}