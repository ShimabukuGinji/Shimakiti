package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.UUID;

/**
 * 投稿情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Getter
@Setter
@Entity
@Table(name="posts")
public class Posts {

	/** ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/** ユーザーID */
	@Column(name = "users_id")
	private int users_id;

	/** カテゴリーID */
	@Column(name = "category_id")
	private int category_id;

	/** 市町村ID */
	@Column(name = "cities_id")
	private int cities_id;

	/** タイトル */
	@Column(name = "title")
	private String title;

	/** 画像UUID */
	@Column(name = "image_uuid")
	private UUID image_uuid;

	/** 概要 */
	@Column(name = "summary")
	private String summary;

	/** 詳細 */
	@Column(name = "detail")
	private String detail;

	/** 住所 */
	@Column(name="address")
	private String address;

	/** 緯度 */
	@Column(name="map_longitude")
	private double map_longitude;

	/** 経度 */
	@Column(name="map_latitude")
	private double map_latitude;

	/** 外部リンク */
	@Column(name = "link")
	private String link;

	/** 投稿日時 */
	@Column(name="created_at", updatable=false)
	private Date created_at;

	/** 編集日時 */
	@Column(name = "updated_at")
	private Date updated_at;
}
