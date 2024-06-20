package com.example.shimakiti.repository;

import com.example.shimakiti.entity.Notices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticesRepository extends JpaRepository<Notices, Integer> {

    @Query("SELECT n FROM Notices n ORDER BY n.id DESC LIMIT 3")
    List<Notices> findTop3ByOrderByIdDesc();
}
