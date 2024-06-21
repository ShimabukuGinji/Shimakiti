package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
	@ManyToOne
	@JoinColumn(name = "users_id")
	private User user;

	/** カテゴリーID */
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Categories categories;

	/** 市町村ID */
	@ManyToOne
	@JoinColumn(name = "cities_id")
	private Cities cities;

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
	@Column(name="created_at", insertable=false, updatable=false)
	private Date created_at;

	/** 編集日時 */
	@Column(name = "updated_at")
	private Date updated_at;

}
