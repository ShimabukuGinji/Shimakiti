package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * お知らせカテゴリー情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Getter
@Setter
@Entity
@Table(name="notice_category")
public class NoticeCategory {

	/** ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/** ユーザー名 */
	@Column(name = "priority")
	private String priority;

}
