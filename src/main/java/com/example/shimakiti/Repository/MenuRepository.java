package com.example.shimakiti.Repository;

import com.example.shimakiti.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MenuRepository extends JpaRepository<Notice, Integer> {
}