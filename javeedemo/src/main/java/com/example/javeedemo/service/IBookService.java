package com.example.javeedemo.service;

import com.example.javeedemo.controller.request.BaseRequest;
import com.example.javeedemo.entity.Book;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBookService {

    List<Book> list();

    PageInfo<Book> page(BaseRequest baseRequest);

    PageInfo<Book> page2(BaseRequest baseRequest);

    void save(Book obj);

    void updateUpload(Integer id);

    void updateUpload1(Integer id);

    Book getById(Integer id);

    void update(Book obj);

    void deleteById(Integer id);

    void save2(Book obj);

    void update3(String statement, Integer id);
}
