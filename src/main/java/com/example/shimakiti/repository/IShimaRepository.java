package com.example.shimakiti.repository;

import com.example.shimakiti.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IShimaRepository extends JpaRepository<Posts,Long> {

}
