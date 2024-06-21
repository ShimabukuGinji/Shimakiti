package com.example.shimakiti.dto;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Cities;
import com.example.shimakiti.entity.User;
import lombok.Data;

import java.util.Date;

/**
 * ユーザー登録画面 form
 * 
 * @author ys-fj
 *
 */
@Data
public class PostResult {

	/** ID */
	private int id;

	/** カテゴリー名 */
	private Categories categories;

	/** 市町村名 */
	private Cities cities;

	/** ユーザー名 */
	private User user;

	/** タイトル */
	private String title;

	/** 画像1 */
	private String imageFile1;

	/** 画像2 */
	private String imageFile2;

	/** 画像3 */
	private String imageFile3;

	/** 画像4 */
	private String imageFile4;

	/** 画像5 */
	private String imageFile5;

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

	/** 投稿日時 */
	private Date created_at;

	/** 編集日時 */
	private Date updated_at;
}
