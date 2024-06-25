package com.example.shimakiti.From;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Cities;
import com.example.shimakiti.entity.User;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


/**
 * ユーザー登録画面 form
 * 
 * @author ys-fj
 *
 */
@Setter
@Getter
@Data
public class PostForm {

	/** ID */
	private int id;

	/** カテゴリーID */
	@NotNull(message = "※カテゴリを選択してください")
	private Categories categories;

	/** 市町村ID */
	@NotNull(message = "※市町村を選択してください")
	private Cities cities;

	/** ユーザーID */
	private User user;

	/** タイトル */
	@NotEmpty( message = "※タイトルを入力してください" )
	@Size(max = 50, message = "※タイトルは100文字以内で入力してください")
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
	@Size(max = 50, message = "※概要は50文字以内で入力してください")
	private String summary;

	/** 詳細 */
	@Size(max = 2000, message = "※詳細は2000文字以内で入力してください")
	private String detail;

	/** 住所 */
	@Size(max = 255, message = "※住所は255文字以内で入力してください")
	private String address;

	/** 外部リンク */
	@Size(max = 200, message = "※リンクは200文字以内で入力してください")
	private String link;

	/** 緯度 */
	private double map_longitude;

	/** 経度 */
	private double map_latitude;
}
