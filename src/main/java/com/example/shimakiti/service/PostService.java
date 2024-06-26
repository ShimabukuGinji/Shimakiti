package com.example.shimakiti.service;

import com.example.shimakiti.From.PostForm;
import com.example.shimakiti.dto.PostResult;
import com.example.shimakiti.entity.*;
import com.example.shimakiti.repository.*;

import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
@RequiredArgsConstructor
public class PostService {
    /** 投稿情報テーブルRepository */
    private final PostRepository postRepository;

    /** カテゴリー情報テーブルRepository */
    private final CategoriesRepository categoryRepository;

    /** 市町村情報テーブルRepository */
    private final CityRepository cityRepository;

    /** 市町村情報テーブルRepository */
    private final UserRepository userRepository;

    /** いいね情報テーブルRepository */
    private final LikesRepository likesRepository;

    /** ブックマーク情報テーブルRepository */
    private final BookmarkRepository bookmarksRepository;

    /** コメント情報テーブルRepository */
    private final CommentsRepository commentsRepository;

    /** Dozer Mapper */
    private final Mapper mapper;

    /** プロフィール画像の保存先フォルダ */
    @Value("${image.folder}")
    private String imgFolder;

    /** プロフィール画像の保管拡張子 */
    @Value("${image.extract}")
    private String imgExtract;

    /** NoImage画像 */
    @Value("${image.default}")
    private String imgDefault;

    public List<Posts> findAllPosts() {
        return postRepository.findAll();
    }

    public List<Posts> findByUser(User user) {
        return postRepository.findByUsers(user);
    }

    public Posts findById(int id) {
        return postRepository.findById(id).get();
    }

    public List<Posts> findByCategoriesPosts(Categories categories){
        return postRepository.findByCategories(categories);
    }

    public List<PostResult> findPosts(String category, String keyword, String region) throws IOException {
        var posts = postRepository.findPostsByCriteria(category, keyword, region);
        if (!StringUtils.hasText(category) && !StringUtils.hasText(keyword) && !StringUtils.hasText(region)) {
            posts = postRepository.findAll();
        }
        List<PostResult> postResults = new ArrayList<>();
        for (var post :posts) {
            postResults.add(postResult(post.getId()).get());
        }
        return postResults;
    }

    public List<PostResult> postResults() throws IOException {
        var posts = postRepository.findAll();
        List<PostResult> postResults = new ArrayList<>();
        for (var post :posts) {
            postResults.add(postResult(post.getId()).get());
        }
        return postResults;
    }

    /**
     * {@inheritDoc}
     */
    public void insert(PostForm form) throws IOException {
        // DB更新
        var imageID = UUID.randomUUID();
        Categories categories = categoryRepository.findById(form.getCategories().getId()).get();
        Cities cities = cityRepository.findById(form.getCities().getId()).get();
        var postInfo = mapper.map(form, Posts.class);
        postInfo.setCategories(categories);
        postInfo.setCities(cities);
        postInfo.setImage_uuid(imageID);
        //		セッション情報から取得
        // ユーザーIDを指定　サンプル用（1：管理者 2：島袋款次  3：野村太陽  4：埜村瑠希  5：儀間真貴  6：比嘉奏陽  7：當田大翔 ）
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userRepository.findByUsername(username);
        postInfo.setUsers(user);
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


    public void update(PostForm form, int postId) throws IOException {

        var post = postRepository.findById(postId);
        var imageID = UUID.randomUUID();
        Categories categories = categoryRepository.findById(form.getCategories().getId()).get();
        Cities cities = cityRepository.findById(form.getCities().getId()).get();
        var postInfo = mapper.map(form, Posts.class);
        postInfo.setCategories(categories);
        postInfo.setCities(cities);
        //		セッション情報から取得
        // ユーザーIDを指定　サンプル用（1：管理者 2：島袋款次  3：野村太陽  4：埜村瑠希  5：儀間真貴  6：比嘉奏陽  7：當田大翔 ）
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userRepository.findByUsername(username);
        postInfo.setUsers(user);
        postInfo.setId(postId);
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

    public List<PostResult> postResultsAll() throws IOException {
        var posts = postRepository.findAll();
        List<PostResult> postResults = new ArrayList<>();
        for (var i=1; i<posts.size(); i++) {
            postResults.add(postResult(i).get());
        }
        return postResults;
    }


    public Optional<PostResult> postResult(int postId) throws IOException {
        var postInfoOpt = postRepository.findById(postId);
        if (postInfoOpt.isEmpty()) {
            return Optional.empty();
        }
        var postInfo = postInfoOpt.get();

        var postResult = new PostResult();
        postResult.setId(postInfo.getId());
        postResult.setCategories(postInfo.getCategories());
        postResult.setCities(postInfo.getCities());
        postResult.setUsers(postInfo.getUsers());
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
        postResult.setCreated_at(postInfo.getCreated_at());
        postResult.setUpdated_at(postInfo.getUpdated_at());
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

    /**
     * 投稿情報 削除
     * @param id ユーザーID
     */
    public void delete(int id) {
        Posts post = postRepository.findById(id).get();
        for (var i=1; i<=5; i++) {
            Path path = Paths.get("C:\\post\\" + post.getImage_uuid() + "-" + i + ".jpg");
            File file = new File("C:\\post\\" + post.getImage_uuid() + "-" + i + ".jpg");
            if (file.exists()) {
                try{
                    Files.delete(path);
                }catch(IOException e){
                    System.out.println(e);
                }
            } else {
                System.out.println("ファイルが存在しません");
            }
        }
        List<Likes> likes = likesRepository.findByPost(post);
        likesRepository.deleteAll(likes);
        List<Comments> comments = commentsRepository.findByPost(post);
        commentsRepository.deleteAll(comments);
        List<Bookmarks> bookmarks = bookmarksRepository.findByPost(post);
        bookmarksRepository.deleteAll(bookmarks);
        postRepository.delete(post);
    }

    public List<PostResult> searchUpdatedAtDesc(String category, String keyword, String region) throws IOException {
        var posts = postRepository.findPostsByCriteriaOrderByUpdatedAtDesc(category, keyword, region);
        if (!StringUtils.hasText(category) && !StringUtils.hasText(keyword) && !StringUtils.hasText(region)) {
            posts = postRepository.findAllPostsDesc();
        }
        List<PostResult> postResults = new ArrayList<>();
        for (var post :posts) {
            postResults.add(postResult(post.getId()).get());
        }
        return postResults;
    }

    public List<PostResult> searchUpdatedAtAsc(String category, String keyword, String region) throws IOException {
        var posts = postRepository.findPostsByCriteriaOrderByUpdatedAtAsc(category, keyword, region);
        if (!StringUtils.hasText(category) && !StringUtils.hasText(keyword) && !StringUtils.hasText(region)) {
            posts = postRepository.findAllPostsAsc();
        }
        List<PostResult> postResults = new ArrayList<>();
        for (var post :posts) {
            postResults.add(postResult(post.getId()).get());
        }
        return postResults;
    }
}
