package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * お知らせ情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Getter
@Setter
@Entity
@Table(name="notices")
public class Notices {

	/** ユーザーID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

    @Column(name="category_id", insertable=false, updatable=false)
    private  int category_id;

	@Column(name="detail")
	private String detail;

	@Column(name="title")
	private String title;

	@Column(name="created_at")
	private Date created_at;

	@Column(name = "updated_at")
	private Date updated_at;

}
