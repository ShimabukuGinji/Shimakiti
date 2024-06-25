package com.example.shimakiti.service;


import com.example.shimakiti.dto.PostResult;
import com.example.shimakiti.dto.ProfileResult;
import com.example.shimakiti.entity.User;
import com.example.shimakiti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

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

    public Optional<ProfileResult> profileResult(User user) throws IOException {
        var profileResult = new ProfileResult();
        profileResult.setUser(user);
        profileResult.setImageFile1("data:image/jpg;base64," + outputImage(user.getProfilePicture(),1));
        return Optional.of(profileResult);
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

//    public User registerUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//    public User updateUser(Long id, User userDetails) {
//        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
//        user.setUsername(userDetails.getUsername());
//        user.setEmail(userDetails.getEmail());
//        user.setProfilePicture(userDetails.getProfilePicture());
//        return userRepository.save(user);
//    }
//
//    public void deleteUser(Long id) {
//        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
//        userRepository.delete(user);
//    }
//
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    public List<User> findAllUsers() {
//        return userRepository.findAll();
//    }

}