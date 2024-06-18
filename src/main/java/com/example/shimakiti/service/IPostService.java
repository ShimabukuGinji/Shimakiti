package com.example.shimakiti.service;

import com.example.shimakiti.From.PostForm;

import java.io.IOException;

/**
 * ユーザー登録画面Service Interface
 * 
 * @author ys-fj
 *
 */
public interface IPostService {

	/**
	 * ユーザー登録
	 * 
	 * @param form フォーム情報
	 * @throws IOException
	 */
	public void post(PostForm form) throws IOException;
}
