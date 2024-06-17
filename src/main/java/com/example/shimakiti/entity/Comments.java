package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="comments")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="users_id")
    private int users_id;

    @Column(name="posts_id")
    private int posts_id;

    @Column(name = "content")
    private String content;

    @Column(name="updated_at")
    private Date updated_at;
}
