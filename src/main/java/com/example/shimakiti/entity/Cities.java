package com.example.shimakiti.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 市町村情報テーブル Entity
 * 
 * @author ys-fj
 *
 */
@Getter
@Setter
@Entity
@Table(name="cities")
public class Cities {

	/** 市町村ID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/** 市町村名 */
	@Column(name = "name")
	private String name;
}
