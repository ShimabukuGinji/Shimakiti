package com.example.shimakiti.controller;

import com.example.shimakiti.From.ProfileForm;
import com.example.shimakiti.service.NoticeCategoryService;
import com.example.shimakiti.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UsersController {

    @Autowired
    UserService userService;

    @Autowired
    NoticeCategoryService noticeCategoryService;

    @GetMapping("/my-page")
    public String profile(Model model) throws IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userService.findByUserName(username);
        var profile = userService.profileResult(user);
        model.addAttribute("profile", profile.get());
        model.addAttribute("myPage", 1);
        return "profile";
    }

    @GetMapping("/my-page/edit")
    public String profileEdit(@ModelAttribute @Validated ProfileForm form, Model model) throws IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userService.findByUserName(username);
        var profile = userService.profileResult(user);
        model.addAttribute("profile", profile.get());
        model.addAttribute("myPage", 1);
        return "profile";
    }

    @PostMapping("/my-page/edit")
    public String profileUpdate(Model model) throws IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = userService.findByUserName(username);
        var profile = userService.profileResult(user);
        model.addAttribute("profile", profile.get());
        model.addAttribute("myPage", 1);
        return "profile";
    }

    @GetMapping("/profile/{userId}")
    public String profile(@PathVariable("userId") int userId, Model model) throws IOException {
        var user = userService.findById(userId);
        var profile = userService.profileResult(user);
        model.addAttribute("profile", profile.get());
        model.addAttribute("myPage", 2);
        return "profile";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
//
//    public String detail(@PathVariable("postID") int postId, Model model) throws IOException {
//        var post = postservice.postResult(postId);
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        var user = userRepository.findByUsername(username);
//        if (post.isPresent()) {
//            model.addAttribute("post",post.get());
//            System.out.println(post.get().getCreated_at());
//            return "post-detail";
//        }
//        return "redirect:/posts";
//    }
//
//    @GetMapping("/user-insert")
//    public String displayNoticeInsert(Model model){
//
//        List<NoticeCategory> noticeCategory = noticeCategoryService.findALLnCategory();
//
//        model.addAttribute("notice", new Notices());
//        model.addAttribute("noticeCategory", noticeCategory);
//        return "notice-insert";
//    }

//    @PostMapping("/notice-insert")
//    public  String displayNoticeInsertPost(@ModelAttribute Notices notices){
//        noticesService.insert(notices);
//        return "redirect:/notice";
//    }
//
//    @GetMapping("/notice-edit/{id}")
//    public  String displayNoticeEdit(@PathVariable int id, Model model){
//        List<NoticeCategory> noticeCategory = noticeCategoryService.findALLnCategory();
//        Notices notices = noticesService.findById(id);
//        model.addAttribute("notice", notices);
//        model.addAttribute("noticeCategory", noticeCategory);
//
//        Notices newNotices = new Notices();
//        newNotices.setId(notices.getId());
//        newNotices.setTitle(notices.getTitle());
//        newNotices.setDetail(notices.getDetail());
//
//        return "notice-edit";
//    }
//
//    @PostMapping("/notice-edit/{id}")
//    public  String displayNoticeEditPost(@ModelAttribute Notices notices){
//        System.out.println("Received entity: " + notices);
//        noticesService.update(notices);
//        return "redirect:/notice";
//    }
//
//    @PostMapping("/notice-delete/{id}")
//    public String displayNoticeDeletePost(@PathVariable("id") int id, Model model ){
//        try {
//            noticesService.delete(id);
//            return "redirect:/notice";
//        }catch (Exception e){
//            return "redirect:/notice-detail/{id}";
//        }
//    }
}