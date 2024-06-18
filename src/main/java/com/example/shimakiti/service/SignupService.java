package com.example.shimakiti.service;

import com.example.shimakiti.From.SignupForm;

import java.io.IOException;

/**
 * ユーザー登録画面Service Interface
 * 
 * @author ys-fj
 *
 */
public interface SignupService {

	/**
	 * ユーザー登録
	 * 
	 * @param form フォーム情報
	 * @throws IOException
	 */
	public void signup(SignupForm form) throws IOException;
}
