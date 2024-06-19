package com.example.shimakiti.service;

import com.example.shimakiti.From.PostForm;
import com.example.shimakiti.dto.PostResult;

import java.io.IOException;
import java.util.Optional;

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

	public Optional<PostResult> postResult(int userId) throws IOException;
}
