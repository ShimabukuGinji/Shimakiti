package com.example.shimakiti.repository;

import com.example.shimakiti.entity.PostInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ユーザー情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface PostInfoRepository extends JpaRepository<PostInfo, Long> {
}