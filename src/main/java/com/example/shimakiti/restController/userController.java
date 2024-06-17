//package com.example.shimakiti.controller;
//
//import com.example.shimakiti.entity.User;
//import com.example.shimakiti.service.UserService;
//import org.hibernate.mapping.Array;
//import org.hibernate.mapping.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
////
////    @GetMapping("login")
////    public ResponseEntity<List<User>> login(){
////        var user1 = userService.findAll();
////        return ResponseEntity.ok(user1);
////    }
////
////    @PostMapping("/register")
////    public ResponseEntity<User> registerUser(@RequestBody User user) {
////        return ResponseEntity.ok(userService.registerUser(user));
////    }
////
////    @GetMapping("/{username}")
////    public ResponseEntity<User> getUserProfile(@PathVariable String username) {
////        User user = userService.findByUsername(username);
////        return ResponseEntity.ok(user);
////    }
////
////    @PutMapping("/{username}")
////    public ResponseEntity<User> updateUserProfile(@PathVariable String username, @RequestBody User updatedUser) {
////        User user = userService.findByUsername(username);
////        user.setUsername(updatedUser.getUsername());
////        user.setEmail(updatedUser.getEmail());
////        user.setProfilePicture(updatedUser.getProfilePicture());
////        userService.save(user);
////        return ResponseEntity.ok(user);
////    }
////
////    @DeleteMapping("/{username}")
////    public ResponseEntity<Void> deleteUserProfile(@PathVariable String username) {
////        userService.deleteByUsername(username);
////        return ResponseEntity.ok().build();
////    }
//
//}