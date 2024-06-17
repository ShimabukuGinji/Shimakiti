package com.example.shimakiti.Service;

import com.example.shimakiti.Repository.MenuRepository;
import com.example.shimakiti.entity.Notice;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<Notice> getAllNotices() {
        return menuRepository.findAll();
    }

}
