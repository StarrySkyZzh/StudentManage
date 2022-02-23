package com.example.demo.controller;

import com.example.demo.bean.Analysis;
import com.example.demo.bean.StudentCourse;
import com.example.demo.bean.User;
import com.example.demo.service.StudentCourseService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.plugin.dom.core.Element;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentCourseService studentCourseService;

    @GetMapping("/StudentGrade_table")
    public String StudentGrade_table(Model model, HttpSession seesion){

        User loginUser= (User) seesion.getAttribute("loginUser");
        if(loginUser.getCapacity().equals("学生")) {
            List<StudentCourse> list = studentCourseService.find(loginUser.getUserId());

            model.addAttribute("students", list);

            return "Table/StudentGrade_table";
        }else{
            return "405";
        }
    }


    @GetMapping("/editable_table")
    public String editable_table(HttpSession seesion,Model model){
        User loginUser= (User) seesion.getAttribute("loginUser");
        if(loginUser.getCapacity().equals("老师")){
             List<StudentCourse> list2= teacherService.findall(loginUser.getUserId());
             model.addAttribute("students",list2);
             return "Table/editable_table";
        }else{
            return "404";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id){
        studentCourseService.delete(id);
        return "redirect:/editable_table";
    }


    @RequestMapping("/Update/{id}")
    public String Update(@PathVariable("id") String id,String grade){
        studentCourseService.Update(id, grade);
        return "redirect:/editable_table";
    }

    @GetMapping("/GradeAnalysis")
    public String GradeAnalysis(HttpSession seesion,Model model){
        User loginUser= (User) seesion.getAttribute("loginUser");
        if(loginUser.getCapacity().equals("老师")) {
            List<Analysis> list3 = teacherService.analysis(loginUser.getUserId());

            model.addAttribute("analyses", list3);

            return "Table/GradeAnalysis";
        }else{
            return "404";
        }
    }
}
