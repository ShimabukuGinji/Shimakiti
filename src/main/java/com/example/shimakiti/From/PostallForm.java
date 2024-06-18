package com.example.shimakiti.From;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * ユーザー登録画面 form
 * 
 * @author ys-fj
 *
 */
@Data
public class PostallForm {

	/** id */
	private long id;

	/** カテゴリーID */
	private long categoryId;

	/** 市町村ID */
	private long citiesId;

	/** ユーザーID */
	private long usersId;

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

	/** 緯度 */
	private long mapLongitude;

	/** 経度 */
	private long mapLatitude;

	/** 外部リンク */
	private String link;

	/** 投稿日 */
	private Date created_at;

	/** 編集日 */
	private Date updated_at;
}
