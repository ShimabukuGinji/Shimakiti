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
	public void insert(PostForm form) throws IOException;

	public void update(PostForm form, int postId) throws IOException;

	public Optional<PostResult> postResult(int userId) throws IOException;

	public Optional<PostForm> postForm(int userId) throws IOException;
}
