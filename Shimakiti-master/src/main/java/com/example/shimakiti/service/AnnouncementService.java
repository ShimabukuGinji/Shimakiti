package com.example.shimakiti.service;

import com.example.shimakiti.entity.Announcement;
import com.example.shimakiti.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    public Announcement addAnnouncement(String message) {
        Announcement announcement = new Announcement();
        announcement.setMessage(message);
        announcement.setCreatedAt(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return announcementRepository.save(announcement);
    }

    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }
}
