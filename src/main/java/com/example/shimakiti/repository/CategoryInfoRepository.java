package com.example.shimakiti.repository;

import com.example.shimakiti.entity.CategoryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ユーザー情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface CategoryInfoRepository extends JpaRepository<CategoryInfo, Integer> {
}