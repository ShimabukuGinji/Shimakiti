package com.example.shimakiti.dto;

import com.example.shimakiti.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * ユーザー登録画面 form
 * 
 * @author ys-fj
 *
 */
@Getter
@Setter
public class ProfileResult {

	/** ユーザー名 */
	private User user;

	/** 画像1 */
	private String imageFile1;
}
