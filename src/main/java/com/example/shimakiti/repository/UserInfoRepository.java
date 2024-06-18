package com.example.shimakiti.repository;

import com.example.shimakiti.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ユーザー情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

}
