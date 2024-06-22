package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Cities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<Cities,Integer> {
}