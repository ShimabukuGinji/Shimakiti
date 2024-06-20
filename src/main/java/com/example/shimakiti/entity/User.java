package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="email")
    private String email;

    private int role;

    @Column(name="profile_picture")
    private String profilePicture;

    @Column(name = "bio")
    private String bio;

    @Column(name="created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

//    @OneToMany(mappedBy = "user")
//    private List<Bookmarks> bookmarks;
}