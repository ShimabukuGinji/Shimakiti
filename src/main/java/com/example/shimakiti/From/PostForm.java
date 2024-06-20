package com.example.shimakiti.From;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


/**
 * ユーザー登録画面 form
 * 
 * @author ys-fj
 *
 */
@Data
public class PostForm {

	/** ID */
	private int id;

	/** カテゴリーID */
	private int category_id;

	/** 市町村ID */
	private int cities_id;

	/** ユーザーID */
	private int users_id;

	/** タイトル */
	private String title;

	/** 画像1 */
	private MultipartFile imageFile1;

	/** 画像2 */
	private MultipartFile imageFile2;

	/** 画像3 */
	private MultipartFile imageFile3;

	/** 画像4 */
	private MultipartFile imageFile4;

	/** 画像5 */
	private MultipartFile imageFile5;

	/** 概要 */
	private String summary;

	/** 詳細 */
	private String detail;

	/** 住所 */
	private String address;

	/** 外部リンク */
	private String link;

	/** 緯度 */
	private double map_longitude;

	/** 経度 */
	private double map_latitude;
}
