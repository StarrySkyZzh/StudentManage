package com.example.demo.service;

import com.example.demo.bean.StudentCourse;

import java.util.List;

public interface StudentCourseService {
    List<StudentCourse> find(String id);

    void delete(String id);

    void Update(String id,String grade);
}
