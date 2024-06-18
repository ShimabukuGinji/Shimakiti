package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

/**
 * ユーザ情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Entity
@Table(name = "posts")
@Data
public class PostallInfo {

	/** ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	/** カテゴリーID */
	@Column(name = "category_id")
	private long categoryId;

	/** 市町村ID */
	@Column(name = "cities_id")
	private long citiesId;

	/** ユーザーID */
	@Column(name = "users_id")
	private long usersId;

	/** タイトル */
	@Column(name = "title")
	private String title;

	/** 概要 */
	@Column(name = "summary")
	private String summary;

	/** 詳細 */
	@Column(name = "detail")
	private String detail;

	/** 住所 */
	@Column(name = "address")
	private String address;

	/** 緯度 */
	@Column(name = "map_longitude")
	private long mapLongitude;

	/** 経度 */
	@Column(name = "map_latitude")
	private long mapLatitude;

	/** 外部リンク */
	@Column(name = "link")
	private String link;

	/** 投稿日時 */
	@CreatedDate
	@Column(name = "created_at", updatable=false)
	private Date createdAt;

	/** 編集日時 */
	@LastModifiedDate
	@Column(name = "updated_at")
	private Date updatedAt;
}
