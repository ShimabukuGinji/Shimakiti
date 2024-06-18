package com.example.shimakiti.repository;

import com.example.shimakiti.entity.PostInfo;
import com.example.shimakiti.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ユーザー情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface PostInfoRepository extends JpaRepository<PostInfo, String> {
}
