package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts, Integer> {

    @Query("SELECT p FROM Posts p WHERE " +
            "(:category IS NULL OR :category = '' OR p.categories.name = :category) AND " +
            "(:keyword IS NULL OR :keyword = '' OR p.title LIKE %:keyword% OR p.summary LIKE %:keyword%) AND " +
            "(:region IS NULL OR :region = '' OR p.cities.name = :region)")
    List<Posts> findPostsByCriteria(@Param("category") String category,
                                    @Param("keyword") String keyword,
                                    @Param("region") String region);

    List<Posts> findByCategories(Categories categories);

}
