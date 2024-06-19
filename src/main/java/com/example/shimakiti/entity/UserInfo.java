package com.example.shimakiti.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザ情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Entity
@Table(name = "user_info")
@Data
public class UserInfo {

	/** ユーザーID */
	@Id
	@Column(name = "user_id")
	private int userId;

	/** ユーザー名 */
	@Column(name = "user_name")
	private String userName;

}
