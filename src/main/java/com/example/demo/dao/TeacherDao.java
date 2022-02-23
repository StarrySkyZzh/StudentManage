package com.example.demo.dao;

import com.example.demo.bean.Analysis;
import com.example.demo.bean.StudentCourse;
import com.example.demo.bean.Teacher;
import com.example.demo.bean.User;

import java.util.List;

public interface TeacherDao {
    List<Teacher> find(User user);
    List<StudentCourse> findall(String id);
    List<Analysis> analysis(String id);
}
