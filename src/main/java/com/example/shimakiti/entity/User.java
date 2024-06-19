package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * ユーザ情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Entity
@Table(name = "users")
@Data
public class User {

	/** ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/** ユーザー名 */
	@Column(name="username")
	private String username;

	/** パスワード */
	@Column(name = "password")
	private String password;

	/** メールアドレス(ログインID) */
	@Column(name="email")
	private String email;

	/** 権限 */
	@Column(name = "role")
	private int role;

	/** プロフィール画像 */
	@Column(name="profile_picture")
	private String profilePicture;

	/** 自己紹介 */
	@Column(name = "bio")
	private String bio;

	/** 登録日 */
	@Column(name="created_at", updatable=false)
	private Date created_at;

	/** 更新日 */
	@Column(name = "updated_at")
	private Date updated_at;

}
