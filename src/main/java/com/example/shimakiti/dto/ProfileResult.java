package com.example.shimakiti.dto;

import com.example.shimakiti.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * ユーザー登録画面 form
 * 
 * @author ys-fj
 *
 */
@Getter
@Setter
public class ProfileResult {

	/** ID */
	private int id;

	/** ログインID　メールアドレス */
	private String username;

	/** パスワード */
	private String password;

	/** ユーザー名 */
	private String name;

	/** プロフィール画像 */
	private String profilePicture;

	/** 自己紹介 */
	private String bio;
}
