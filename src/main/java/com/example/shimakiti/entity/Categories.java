package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * カテゴリー情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Getter
@Setter
@Entity
@Table(name = "categories")
public class Categories {

	/** カテゴリーID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/** カテゴリー名 */
	@Column(name = "name")
	private String name;
}
