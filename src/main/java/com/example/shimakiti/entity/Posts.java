package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name="posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="title")
    private String title;

    @Column(name="image_uuid")
    private UUID image_uuid;

    @Column(name="summary")
    private String summary;

    @Column(name="detail")
    private String detail;

    @Column(name="address")
    private String address;

    @Column(name="map_longitude")
    private double map_longitude;

    @Column(name="map_latitude")
    private double map_latitude;

    @Column(name="link")
    private String link;

    @Column(name="created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User users;//投稿ユーザ情報

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;//カテゴリ情報

    @ManyToOne
    @JoinColumn(name = "cities_id")
    private Cities cities;//市町村情報

//    @OneToMany(mappedBy = "post")
//    private List<Bookmarks> bookmarks;
}
