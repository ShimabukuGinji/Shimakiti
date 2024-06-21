package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Categories,Long> {


}
