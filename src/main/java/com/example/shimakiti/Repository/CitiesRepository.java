package com.example.shimakiti.Repository;

import com.example.shimakiti.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<Categories, Long> {
}
