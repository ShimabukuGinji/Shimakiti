package com.example.shimakiti.repository;

import com.example.shimakiti.entity.NoticeCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * お知らせカテゴリー情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface NoticeCategoryRepository extends JpaRepository<NoticeCategory, Integer> {
}