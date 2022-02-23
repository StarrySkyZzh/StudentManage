package com.example.demo.service;

import com.example.demo.bean.StudentCourse;
import com.example.demo.dao.StudentCourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentCourseServiceImpl implements StudentCourseService{

    @Autowired
    private StudentCourseDao studentCourseDao;

    @Override
    public List<StudentCourse> find(String id) {
        List<StudentCourse> list=studentCourseDao.find(id);
        return list;
    }

    @Override
    public void delete(String id) {
        studentCourseDao.delete(id);
    }

    @Override
    public void Update(String id, String grade) {
        studentCourseDao.Update(id,grade);
    }
}
