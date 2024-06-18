package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Data;

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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

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

	/** 概要 */
	@Column(name = "link")
	private String link;

	/** 詳細 */
	@Column(name = "map_longitude")
	private long mapLongitude;

	/** 住所 */
	@Column(name = "map_latitude")
	private long mapLatitude;
}
