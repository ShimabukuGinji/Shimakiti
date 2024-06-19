package com.example.shimakiti.repository;

import com.example.shimakiti.entity.CityInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * ユーザー情報テーブルDAO
 * 
 * @author ys-fj
 *
 */
public interface CityInfoRepository extends JpaRepository<CityInfo, Integer> {
    CityInfo findByName(String name);
}