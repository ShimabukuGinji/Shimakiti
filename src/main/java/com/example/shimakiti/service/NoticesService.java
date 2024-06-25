package com.example.shimakiti.service;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Notices;
import com.example.shimakiti.repository.CategoriesRepository;
import com.example.shimakiti.repository.NoticeCategoryRepository;
import com.example.shimakiti.repository.NoticesRepository;
import jakarta.persistence.EntityGraph;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticesService {

    @Autowired
    private NoticesRepository noticeRepository;

    public List<Notices> findTop3ByOrderByIdDesc(){

        return noticeRepository.findAll();
    }

    public List<Notices> findAllNotices(){
        return noticeRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    public Notices findById(int id){
        return noticeRepository.findById(id).orElse(null);
    }

    public String insert(Notices notices) {
        noticeRepository.save(notices);
        return "success!!";
    }

    public String update(Notices notices) {
        noticeRepository.save(notices);
        return "success!!";
    }

    public String delete(int id){
        noticeRepository.deleteById(id);
        return "success!!";
    }
}
