package com.example.shimakiti.controller;

import com.example.shimakiti.From.PostForm;
import com.example.shimakiti.repository.CategoriesRepository;
import com.example.shimakiti.repository.CitiesRepository;
import com.example.shimakiti.repository.PostsRepository;
import com.example.shimakiti.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;


/**
 * ユーザー登録画面Controller
 * 
 * @author ys-fj
 *
 */
@Controller
@RequiredArgsConstructor
public class PostController {

	/** 投稿画面Service */
	private final PostService postservice;

	/** 投稿情報テーブルDAO */
	private final PostsRepository postRepository;

	/** カテゴリー情報テーブルDAO */
	private final CategoriesRepository categoryRepository;

	/** 市町村情報テーブルDAO */
	private final CitiesRepository cityRepository;

	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form フォーム
	 * @return 画面名
	 */
	@GetMapping("/posts")
	public String view(PostForm form, Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("cities", cityRepository.findAll());
		return "post-insert";
	}

	/**
	 * ユーザー登録
	 * 
	 * @param form フォーム
	 * @return リダイレクト先
	 * @throws IOException
	 */
	@PostMapping("/posts")
	public String post(PostForm form, Model model) throws IOException {
		postservice.insert(form);
		return "redirect:/posts";
	}

	/**
	 * 詳細画面
	 *
	 * @param model モデル
	 * @return 画面名
	 */
	@GetMapping("/posts/detail/{postID}")
	public String detail(@PathVariable("postID") int postId, Model model) throws IOException {
		var post = postservice.postResult(postId);
		if (post.isPresent()) {
			model.addAttribute("post",post.get());
			return "post-detail";
		}
		return "redirect:/menu";
	}

	/**
	 * 詳細画面
	 *
	 * @param model モデル
	 * @return 画面名
	 */
	@GetMapping("/posts/edit/{postID}")
	public String edit(@PathVariable("postID") int postId, PostForm form, Model model) throws IOException {
		var postForm = postservice.postForm(postId);
		var postResult = postservice.postResult(postId);
		if (postForm.isPresent() && postResult.isPresent()) {
			model.addAttribute("categories", categoryRepository.findAll());
			model.addAttribute("cities", cityRepository.findAll());
			model.addAttribute("postForm",postForm.get());
			model.addAttribute("post",postResult.get());
			return "post-edit";
		}
		return "redirect:/menu";
	}

	@PostMapping("/posts/edit/{postID}")
	public String update(@PathVariable("postID") int postId, PostForm form, Model model) throws IOException {
		postservice.update(form, postId);
		return "redirect:/posts";
	}
}
