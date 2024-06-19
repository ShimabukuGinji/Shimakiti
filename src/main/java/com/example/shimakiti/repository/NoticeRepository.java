package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Notices;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * お知らせ情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface NoticeRepository extends JpaRepository<Notices, Integer> {
}