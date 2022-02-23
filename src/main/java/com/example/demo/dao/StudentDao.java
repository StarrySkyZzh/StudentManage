package com.example.demo.dao;

import com.example.demo.bean.Student;
import com.example.demo.bean.User;

import java.util.List;

public interface StudentDao {

    List<Student> find(User user);
}
