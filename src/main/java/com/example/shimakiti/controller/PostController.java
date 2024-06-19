package com.example.shimakiti.controller;

import com.example.shimakiti.From.PostForm;
import com.example.shimakiti.repository.CategoryInfoRepository;
import com.example.shimakiti.repository.CityInfoRepository;
import com.example.shimakiti.repository.PostInfoRepository;
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
	private final PostInfoRepository postRepository;

	/** カテゴリー情報テーブルDAO */
	private final CategoryInfoRepository categoryRepository;

	/** 市町村情報テーブルDAO */
	private final CityInfoRepository cityRepository;

	/**
	 * 初期表示
	 * 
	 * @param model モデル
	 * @param form フォーム
	 * @return 画面名
	 */
	@GetMapping("/posts")
	public String view(Model model, PostForm form) {
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("cities", cityRepository.findAll());
		var category = categoryRepository.findAll();
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
		postservice.post(form);
		return "redirect:/posts";
	}

	/**
	 * 詳細画面
	 *
	 * @param model モデル
	 * @return 画面名
	 */
	@GetMapping("/posts/users/{postID}")
	public String view(@PathVariable("postID") long postId, Model model) throws IOException {
		var post = postservice.postResult(postId);
		var posts = postservice.postResult(postId);
		if (post.isPresent()) {
			model.addAttribute("post",post.get());
			System.out.println(post.get().getImageFile1());
			return "post-detail";
		}
		return "redirect:/menu";
	}
}
