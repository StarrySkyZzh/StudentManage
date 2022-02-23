package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
     /**
     * 来登录页
     * @return
     */

     @Autowired
     private UserService userService;

    @GetMapping(value={"/","/login"})
    public String loginPage(){
        return "login";
    }

   @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        User login=userService.login(user.getUserId(), user.getUserName(), user.getPassword(), user.getCapacity());
        if(login!=null){
            session.setAttribute("loginUser",user);
            return "redirect:/main";
        }
        else {
            model.addAttribute("msg","账号或密码错误");
            return "login";
        }
    }

    @GetMapping("/main")
    public String mainpage(HttpSession seesion,Model model){
        Object loginUser=seesion.getAttribute("loginUser");
        if(loginUser!=null){
            return "main";
        }
        else {
            model.addAttribute("msg","请重新登录");
            return "login";
        }
    }

}


