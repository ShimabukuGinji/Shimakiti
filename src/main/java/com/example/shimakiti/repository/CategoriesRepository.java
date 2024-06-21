package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * カテゴリー情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {

}