package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * ブックマーク情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Getter
@Setter
@Entity
@Table(name="bookmarks")
public class Bookmarks {

	/** ブックマークID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	/** ユーザーID */
	@Column(name="users_id")
	private int users_id;

	/** 投稿ID */
	@Column(name="posts_id")
	private int posts_id;

}
