package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//投稿ID
    private String title;//店舗名
    private String detail;//詳細
//    private String imageUrl;//URL
    private String summary;//概要
    private String address;//住所
    private String mapLongitude;//緯度
    private String mapLatitude;//軽度
    private String link;//店舗ホームページなどURL
    private Date createdAt;//投稿日
    private Date updatedAt;//更新日

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;//投稿ユーザ情報

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories categories;//カテゴリ情報

    @ManyToOne
    @JoinColumn(name = "cities_id")
    private Cities cities;//市町村情報
}