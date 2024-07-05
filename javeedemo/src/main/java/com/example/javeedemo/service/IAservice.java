package com.example.javeedemo.service;

import com.example.javeedemo.controller.dto.LoginDTO;
import com.example.javeedemo.controller.request.BaseRequest;
import com.example.javeedemo.controller.request.LoginRequest;
import com.example.javeedemo.controller.request.PasswordRequest;
import com.example.javeedemo.controller.request.UserPageRequest;
import com.example.javeedemo.entity.Admin;
import com.example.javeedemo.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IAservice {
    List<Admin> list();

    PageInfo<Admin> page(BaseRequest baseRequest);
    void save(Admin obj);

    Admin getById(Integer id);

    void update(Admin obj);

    void deleteById(Integer id);

    LoginDTO login(LoginRequest request);

    void changePass(PasswordRequest request);

    LoginDTO login1(LoginRequest request);
}

