package com.example.shimakiti.repository;

import com.example.shimakiti.entity.*;
import com.example.shimakiti.service.ShimaService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IShimaRepository extends JpaRepository<Posts,Long> {
    List<Posts> findByCategories(Categories categories);
}
