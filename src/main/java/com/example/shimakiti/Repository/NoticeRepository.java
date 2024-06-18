//MenuRepository
package com.example.shimakiti.Repository;

import com.example.shimakiti.entity.Notices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NoticeRepository extends JpaRepository<Notices, Long> {
    @Query("SELECT n FROM Notices n ORDER BY n.id DESC LIMIT 3")
    List<Notices> findTop3ByOrderByIdDesc();
}