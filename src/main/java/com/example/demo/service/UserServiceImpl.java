package com.example.demo.service;

import com.example.demo.bean.User;
import com.example.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;


    @Override
    public void register(User user) {
       userDao.save(user);
    }

    @Override
    public User login(String id, String name, String password, String capacity) {
        return userDao.login(id,name, password,capacity);
    }
}
