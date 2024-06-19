package com.example.shimakiti.repository;

import com.example.shimakiti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ユーザー情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
