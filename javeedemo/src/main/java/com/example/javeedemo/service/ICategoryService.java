package com.example.javeedemo.service;

import com.example.javeedemo.controller.request.BaseRequest;
import com.example.javeedemo.entity.Category;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICategoryService {
    List<Category> list();

    PageInfo<Category> page(BaseRequest baseRequest);

    void save(Category obj);

    Category getById(Integer id);

    void update(Category obj);

    void deleteById(Integer id);
}
