package com.example.shimakiti.service;

import com.example.shimakiti.From.PostForm;
import com.example.shimakiti.entity.PostInfo;
import com.example.shimakiti.repository.PostInfoRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * ユーザー登録画面Service
 * 
 * @author ys-fj
 *
 */
@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

	/** 投稿テーブルRepository */
	private final PostInfoRepository repository;

	/** Dozer Mapper */
	private final Mapper mapper;

	/** プロフィール画像の保存先フォルダ */
	@Value("${image.folder}")
	private String imgFolder;

	/** プロフィール画像の保管拡張子 */
	@Value("${image.extract}")
	private String imgExtract;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void post(PostForm form) throws IOException {
		// DB更新
		var postInfo = mapper.map(form, PostInfo.class);
		repository.save(postInfo);

		if (!form.getImageFile1().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = form.getTitle() + "-1" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile1().getInputStream(), imgFilePath);
		}
		if (!form.getImageFile2().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = form.getTitle() + "-2" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile2().getInputStream(), imgFilePath);
		}
		if (!form.getImageFile3().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = form.getTitle() + "-3" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile3().getInputStream(), imgFilePath);
		}
		if (!form.getImageFile4().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = form.getTitle() + "-4" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile4().getInputStream(), imgFilePath);
		}
		if (!form.getImageFile5().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = form.getTitle() + "-5" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile5().getInputStream(), imgFilePath);
		}
	}

}
