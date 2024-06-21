package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * いいね情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Getter
@Setter
@Entity
@Table(name="likes")
public class Likes {

	/** いいねID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	/** ユーザーID */
	@Column(name="users_id")
	private int users_id;


	/** 投稿ID */
	@ManyToOne
	@JoinColumn(name = "posts_id")
	private Posts posts;

}
