package com.example.shimakiti.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "notices")
public class Notice {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "category_id")
    private int category;

    @Column(name = "detail")
    private String detail;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}

