package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 市町村情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface CitiesRepository extends JpaRepository<Cities, Integer> {
    Cities findByName(String name);
}