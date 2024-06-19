package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

/**
 * ユーザ情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Entity
@Table(name = "post")
@Data
public class PostInfo {

	/** ID */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;

	/** カテゴリーID */
	@Column(name = "category_id")
	private int categoryId;

	/** 市町村ID */
	@Column(name = "cities_id")
	private int citiesId;

	/** タイトル */
	@Column(name = "title")
	private String title;

	/** 画像UUID */
	@Column(name = "image_uuid")
	private UUID imageUuid;

	/** 概要 */
	@Column(name = "summary")
	private String summary;

	/** 詳細 */
	@Column(name = "detail")
	private String detail;

	/** 住所 */
	@Column(name = "address")
	private String address;

	/** 外部リンク */
	@Column(name = "link")
	private String link;

	/** 緯度 */
	@Column(name = "map_longitude")
	private double mapLongitude;

	/** 経度 */
	@Column(name = "map_latitude")
	private double mapLatitude;
}
