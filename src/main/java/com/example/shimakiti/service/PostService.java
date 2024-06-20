package com.example.shimakiti.service;

import com.example.shimakiti.From.PostForm;
import com.example.shimakiti.dto.PostResult;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.repository.CategoriesRepository;
import com.example.shimakiti.repository.CitiesRepository;
import com.example.shimakiti.repository.PostsRepository;
import com.example.shimakiti.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.Optional;
import java.util.UUID;

/**
 * ユーザー登録画面Service
 * 
 * @author ys-fj
 *
 */
@Service
@RequiredArgsConstructor
public class PostService implements IPostService {

	/** 投稿情報テーブルRepository */
	private final PostsRepository postRepository;

	/** カテゴリー情報テーブルRepository */
	private final CategoriesRepository categoryRepository;

	/** 市町村情報テーブルRepository */
	private final CitiesRepository cityRepository;

	/** 市町村情報テーブルRepository */
	private final UserRepository userRepository;

	/** Dozer Mapper */
	private final Mapper mapper;

	/** プロフィール画像の保存先フォルダ */
	@Value("${image.folder}")
	private String imgFolder;

	/** プロフィール画像の保管拡張子 */
	@Value("${image.extract}")
	private String imgExtract;

	/** デフォルトプロフィール画像 */
	@Value("${image.default}")
	private String imgDefault;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(PostForm form) throws IOException {
		// DB更新
		var imageID = UUID.randomUUID();
		var postInfo = mapper.map(form, Posts.class);
		postInfo.setImage_uuid(imageID);
		postInfo.setUsers_id(2);
		postRepository.save(postInfo);

		if (!form.getImageFile1().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = imageID + "-1" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile1().getInputStream(), imgFilePath);
		}
		if (!form.getImageFile2().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = imageID + "-2" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile2().getInputStream(), imgFilePath);
		}
		if (!form.getImageFile3().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = imageID + "-3" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile3().getInputStream(), imgFilePath);
		}
		if (!form.getImageFile4().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = imageID + "-4" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile4().getInputStream(), imgFilePath);
		}
		if (!form.getImageFile5().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = imageID + "-5" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile5().getInputStream(), imgFilePath);
		}
	}

	@Override
	public void update(PostForm form, int postId) throws IOException {

		var post = postRepository.findById(postId);
		var imageID = UUID.randomUUID();

		// DB更新
		var postInfo = mapper.map(form, Posts.class);
		postInfo.setId(postId);
		postInfo.setUsers_id(post.get().getUsers_id());
		if (post.get().getImage_uuid() == null) {
			postInfo.setImage_uuid(imageID);
		} else {
			postInfo.setImage_uuid(post.get().getImage_uuid());
		}
		postInfo.setMap_latitude(post.get().getMap_latitude());
		postInfo.setMap_longitude(post.get().getMap_longitude());
		postRepository.save(postInfo);

		if (!form.getImageFile1().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = post.get().getImage_uuid() + "-1" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile1().getInputStream(), imgFilePath, StandardCopyOption.REPLACE_EXISTING);
		}
		if (!form.getImageFile2().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = post.get().getImage_uuid() + "-2" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile2().getInputStream(), imgFilePath, StandardCopyOption.REPLACE_EXISTING);
		}
		if (!form.getImageFile3().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = post.get().getImage_uuid() + "-3" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile3().getInputStream(), imgFilePath, StandardCopyOption.REPLACE_EXISTING);
		}
		if (!form.getImageFile4().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = post.get().getImage_uuid() + "-4" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile4().getInputStream(), imgFilePath, StandardCopyOption.REPLACE_EXISTING);
		}
		if (!form.getImageFile5().isEmpty()) {
			// 保存する画像ファイルのパス設定
			var saveFileName = post.get().getImage_uuid() + "-5" + imgExtract;
			Path imgFilePath = Path.of(imgFolder, saveFileName);

			// 画像ファイルの保存(フォルダ)
			Files.copy(form.getImageFile5().getInputStream(), imgFilePath, StandardCopyOption.REPLACE_EXISTING);
		}
	}

	@Override
	public Optional<PostResult> postResult(int postId) throws IOException {
		var postInfoOpt = postRepository.findById(postId);
		if (postInfoOpt.isEmpty()) {
			return Optional.empty();
		}
		var postInfo = postInfoOpt.get();

		var postResult = new PostResult();
		postResult.setId(postInfo.getId());
		postResult.setCategoryName(categoryRepository.findById(postInfo.getCategory_id()).get().getName());
		postResult.setCitiesName(cityRepository.findById(postInfo.getCities_id()).get().getName());
		postResult.setUsersName(userRepository.findById(postInfo.getUsers_id()).get().getUsername());
		postResult.setUsers_id(postInfo.getUsers_id());
		postResult.setAddress(postInfo.getAddress());
		postResult.setTitle(postInfo.getTitle());
		postResult.setSummary(postInfo.getSummary());
		postResult.setDetail(postInfo.getDetail());
		postResult.setLink(postInfo.getLink());
		postResult.setImageFile1("data:image/jpg;base64," + outputImage(postInfo.getImage_uuid(),1));
		postResult.setImageFile2("data:image/jpg;base64," + outputImage(postInfo.getImage_uuid(),2));
		postResult.setImageFile3("data:image/jpg;base64," + outputImage(postInfo.getImage_uuid(),3));
		postResult.setImageFile4("data:image/jpg;base64," + outputImage(postInfo.getImage_uuid(),4));
		postResult.setImageFile5("data:image/jpg;base64," + outputImage(postInfo.getImage_uuid(),5));
		postResult.setMap_latitude(postInfo.getMap_latitude());
		postResult.setMap_longitude(postInfo.getMap_longitude());
		return Optional.of(postResult);
	}

	private String outputImage(UUID uuid, long i) throws IOException {
		var imgFilePath = searchImage(uuid, i);
		var byteImg = Files.readAllBytes(imgFilePath);

		return Base64.getEncoder().encodeToString(byteImg);
	}

	private Path searchImage(UUID uuid, long i) {
		var searchFileName = uuid + "-" + i + imgExtract;
		var imgFilePath = Path.of(imgFolder, searchFileName);

		return Files.exists(imgFilePath) ? imgFilePath : Path.of(imgFolder, imgDefault + imgExtract);
	}

	@Override
	public Optional<PostForm> postForm(int postId) throws IOException {
		var postInfoOpt = postRepository.findById(postId);
		if (postInfoOpt.isEmpty()) {
			return Optional.empty();
		}
		var postInfo = postInfoOpt.get();

		var postResult = new PostForm();
		postResult.setId(postInfo.getId());
		postResult.setCategory_id(postInfo.getCategory_id());
		postResult.setCities_id(postInfo.getCities_id());
		postResult.setUsers_id(postInfo.getUsers_id());
		postResult.setAddress(postInfo.getAddress());
		postResult.setTitle(postInfo.getTitle());
		postResult.setSummary(postInfo.getSummary());
		postResult.setDetail(postInfo.getDetail());
		postResult.setLink(postInfo.getLink());
		postResult.setMap_latitude(postInfo.getMap_latitude());
		postResult.setMap_longitude(postInfo.getMap_longitude());
		return Optional.of(postResult);
	}

}
