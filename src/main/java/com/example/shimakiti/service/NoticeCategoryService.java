package com.example.shimakiti.service;

import com.example.shimakiti.entity.NoticeCategory;
import com.example.shimakiti.entity.Notices;
import com.example.shimakiti.repository.NoticeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class NoticeCategoryService {

    @Autowired
    NoticeCategoryRepository noticeCategoryRepository;

    public List<NoticeCategory> findALLnCategory(){
        return noticeCategoryRepository.findAll();
    }
}
