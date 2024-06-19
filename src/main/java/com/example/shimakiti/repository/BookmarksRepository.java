package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Bookmarks;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ブックマーク情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface BookmarksRepository extends JpaRepository<Bookmarks, Integer> {
}
