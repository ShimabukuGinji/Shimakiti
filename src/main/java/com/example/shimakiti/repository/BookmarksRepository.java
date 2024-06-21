package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Bookmarks;
import com.example.shimakiti.entity.Comments;
import com.example.shimakiti.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * ブックマーク情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface BookmarksRepository extends JpaRepository<Bookmarks, Integer> {

    List<Bookmarks> findByPosts(Posts posts);
}
