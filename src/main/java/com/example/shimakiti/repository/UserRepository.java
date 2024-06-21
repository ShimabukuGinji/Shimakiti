package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Likes;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ユーザー情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
