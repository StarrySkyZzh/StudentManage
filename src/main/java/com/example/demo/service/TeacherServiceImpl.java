package com.example.demo.service;

import com.example.demo.bean.Analysis;
import com.example.demo.bean.StudentCourse;
import com.example.demo.bean.Teacher;
import com.example.demo.bean.User;
import com.example.demo.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<Teacher> find(User user) {
        return teacherDao.find(user);
    }

    @Override
    public List<StudentCourse> findall(String id) {
        return teacherDao.findall(id);
    }

    @Override
    public List<Analysis> analysis(String id) {
        return teacherDao.analysis(id);
    }
}
