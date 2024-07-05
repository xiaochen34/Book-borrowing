package com.example.javeedemo.service;

import com.example.javeedemo.controller.request.BaseRequest;
import com.example.javeedemo.entity.Borrow;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface IBorrowService {

    List<Borrow> list();
    PageInfo<Borrow> page(BaseRequest baseRequest);
    PageInfo<Borrow> page1(BaseRequest baseRequest);
    void save(Borrow obj);
    Borrow getById(Integer id);
    void update(Borrow obj);
    void deleteById(Integer id);

    void update1(Integer id);
    void update2(Integer id);
    void update3(String statement,Integer id);
    void update4(Integer id);
    PageInfo<Borrow> page2(BaseRequest baseRequest);
}