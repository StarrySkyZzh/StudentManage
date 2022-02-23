package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import com.example.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/registration")
    public  String regist(){
        return "registration";
    }

    @RequestMapping("/registration")
    public String register(User user, Model model){
        if(!studentService.find(user).isEmpty()||!teacherService.find(user).isEmpty()){
            userService.register(user);
            return "redirect:/main";
        }else{
            model.addAttribute("msg","注册的用户查无此人");
            return "/registration";
        }
    }
}
