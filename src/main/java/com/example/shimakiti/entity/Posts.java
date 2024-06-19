package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String summary;



    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;
}