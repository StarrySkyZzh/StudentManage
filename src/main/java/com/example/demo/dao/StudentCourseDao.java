package com.example.demo.dao;

import com.example.demo.bean.StudentCourse;

import java.util.List;

public interface StudentCourseDao {
    List<StudentCourse> find(String id);

    void delete(String id);

    void Update(String id,String grade);
}
