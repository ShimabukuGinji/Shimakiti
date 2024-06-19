package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * ユーザ情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Entity
@Table(name = "cities")
@Data
public class CityInfo {

	/** ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/** タイトル */
	@Column(name = "name")
	private String name;
}
