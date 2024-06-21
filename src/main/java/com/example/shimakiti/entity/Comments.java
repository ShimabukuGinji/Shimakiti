package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * コメント情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Getter
@Setter
@Entity
@Table(name="comments")
public class Comments {

	/** コメントID */
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

	/** コメント内容 */
	@Column(name = "content")
	private String content;

	/** 更新日 */
	@Column(name="updated_at")
	private Date updated_at;

}
