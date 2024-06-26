package com.example.shimakiti.service;

import com.example.shimakiti.From.ProfileForm;
import com.example.shimakiti.dto.ProfileResult;
import com.example.shimakiti.entity.Likes;
import com.example.shimakiti.entity.Posts;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.PostRepository;
import com.example.shimakiti.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    /** Dozer Mapper */
    private final Mapper mapper;

    /** プロフィール画像の保存先フォルダ */
    @Value("${image.profile}")
    private String imgFolder;

    /** プロフィール画像の保管拡張子 */
    @Value("${image.extract}")
    private String imgExtract;

    /** NoImage画像 */
    @Value("${image.unknown}")
    private String imgDefault;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    public User findByUserName(String username){
        return userRepository.findByUsername(username);
    }

    public void deleteUserById(Integer id) { userRepository.deleteById(id);}

    public void updateUser(User user){
        userRepository.save(user);
    }

    public ProfileResult profileResult(User user) throws IOException {
        var profileResult = new ProfileResult();
        profileResult.setId(user.getId());
        profileResult.setName(user.getName());
        profileResult.setUsername(user.getUsername());
        profileResult.setPassword(user.getPassword());
        profileResult.setBio(user.getBio());
        profileResult.setProfilePicture("data:image/jpg;base64," + outputImage(user.getProfile_uuid()));
        return profileResult;
    }

    private String outputImage(UUID uuid) throws IOException {
        var imgFilePath = searchImage(uuid);
        var byteImg = Files.readAllBytes(imgFilePath);

        return Base64.getEncoder().encodeToString(byteImg);
    }

    private Path searchImage(UUID uuid) {
        var searchFileName = uuid + imgExtract;
        var imgFilePath = Path.of(imgFolder, searchFileName);
        return Files.exists(imgFilePath) ? imgFilePath : Path.of(imgFolder, imgDefault + imgExtract);
    }

    public String insert(User user) {
        user.setRole(2);
        userRepository.save(user);
        return "success!!";
    }

    public void update(ProfileForm form) throws IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userRepository.findByUsername(username);
        var imageID = UUID.randomUUID();
        var userInfo = mapper.map(form, User.class);
        userInfo.setId(user.getId());
        userInfo.setRole(user.getRole());
        if (user.getProfile_uuid() == null) {
            userInfo.setProfile_uuid(imageID);
        } else {
            userInfo.setProfile_uuid(user.getProfile_uuid());
        }
        userRepository.save(userInfo);

        if (!form.getProfilePicture().isEmpty()) {
            // 保存する画像ファイルのパス設定
            var saveFileName = user.getProfile_uuid() + imgExtract;
            Path imgFilePath = Path.of(imgFolder, saveFileName);
            // 画像ファイルの保存(フォルダ)
            Files.copy(form.getProfilePicture().getInputStream(), imgFilePath, StandardCopyOption.REPLACE_EXISTING);
        }
    }

    public boolean isuserPost(int postId, String username) {
        User user = userRepository.findByUsername(username);
        Posts post = postRepository.findById(postId).get();
        return user.getId() == post.getUsers().getId();
    }
}