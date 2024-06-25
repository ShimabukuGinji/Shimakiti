package com.example.shimakiti.From;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.Cities;
import com.example.shimakiti.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


/**
 * ユーザー登録画面 form
 * 
 * @author ys-fj
 *
 */
@Setter
@Getter
@Data
public class ProfileForm {

	/** ID */
	private int id;

	/** ログインID　メールアドレス */
	private String username;

	/** パスワード */
	private String password;

	/** ユーザー名 */
	private String name;

	/** プロフィール画像 */
	private MultipartFile profilePicture;

	/** 自己紹介 */
	private String bio;

}
