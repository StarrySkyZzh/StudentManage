package com.example.demo.service;

import com.example.demo.bean.User;

public interface UserService {
    void register(User user);

    User login(String id,String name,String password,String capacity);
}
