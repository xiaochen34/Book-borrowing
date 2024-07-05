package com.example.javeedemo.service;

import com.example.javeedemo.controller.request.BaseRequest;
import com.example.javeedemo.controller.request.UserPageRequest;
import com.example.javeedemo.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IUservice {
    List<User> list();

    PageInfo<User> page(BaseRequest baseRequest);
    void save(User user);

    User getById(Integer id);

    void update(User user);
    void update1(String name);
    void update2(String name);
    void deleteById(Integer id);
}

