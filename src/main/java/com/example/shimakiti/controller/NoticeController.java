package com.example.shimakiti.controller;

import com.example.shimakiti.entity.Categories;
import com.example.shimakiti.entity.NoticeCategory;
import com.example.shimakiti.entity.Notices;
//import com.example.shimakiti.service.NoticesService;
import com.example.shimakiti.repository.NoticeCategoryRepository;
import com.example.shimakiti.service.MenuService;
import com.example.shimakiti.service.NoticeCategoryService;
import com.example.shimakiti.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    NoticesService noticesService;

    @Autowired
    NoticeCategoryService noticeCategoryService;

    @GetMapping("/notice")
    public String displayNotices(Model model) {
        List<Notices> notices = noticesService.findAllNotices();
        model.addAttribute("notices", notices);

        return "notice";
    }

    @GetMapping("/notice-detail/{id}")
    public  String displayNoticeDetail(@PathVariable int id, Model model){

        Notices notices = noticesService.findById(id);
        model.addAttribute("notice", notices);

        return "notice-detail";
    }

    @GetMapping("/admin/notice-insert")
    public String displayNoticeInsert(@ModelAttribute("notice") Notices notices, Model model){
        List<NoticeCategory> noticeCategory = noticeCategoryService.findALLnCategory();
        model.addAttribute("noticeCategory", noticeCategory);

        return "notice-insert";

    }

    @PostMapping("/admin/notice-insert")
    public  String displayNoticeInsertPost(@Validated @ModelAttribute("notice") Notices notices,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            List<NoticeCategory> noticeCategory = noticeCategoryService.findALLnCategory();
            model.addAttribute("noticeCategory", noticeCategory);
            return "notice-insert";
        }
        noticesService.insert(notices);

        return "redirect:/notice";
    }

    @GetMapping("/admin/notice-edit/{id}")
    public  String displayNoticeEdit(@PathVariable int id, @ModelAttribute("notice") Notices notices, Model model){
        List<NoticeCategory> noticeCategory = noticeCategoryService.findALLnCategory();
        Notices notice = noticesService.findById(id);
        model.addAttribute("notice", notice);
        model.addAttribute("noticeCategory", noticeCategory);

        Notices newNotices = new Notices();
        newNotices.setId(notices.getId());
        newNotices.setTitle(notices.getTitle());
        newNotices.setDetail(notices.getDetail());

        return "notice-edit";
    }

    @PostMapping("/admin/notice-edit/{id}")
    public  String displayNoticeEditPost(@PathVariable int id, @Validated @ModelAttribute("notice") Notices notices,BindingResult bindingResult,Model model){
        System.out.println("-----------------------------------");
        if(bindingResult.hasErrors()){
            List<NoticeCategory> noticeCategory = noticeCategoryService.findALLnCategory();
            model.addAttribute("noticeCategory", noticeCategory);
            return "notice-edit";
        }
        noticesService.update(notices);
        return "redirect:/notice";
    }

    @PostMapping("/admin/notice-delete/{id}")
    public String displayNoticeDeletePost(@PathVariable("id") int id, Model model ){
        try {
            noticesService.delete(id);
            return "redirect:/notice";
        }catch (Exception e){
            return "redirect:/admin/notice-detail/{id}";
        }
    }
}
