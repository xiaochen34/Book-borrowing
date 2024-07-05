package com.example.javeedemo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.example.javeedemo.controller.request.BaseRequest;
import com.example.javeedemo.entity.Book;
import com.example.javeedemo.entity.Borrow;
import com.example.javeedemo.entity.User;
import com.example.javeedemo.exception.ServiceException;
import com.example.javeedemo.mapper.BookMapper;
import com.example.javeedemo.mapper.BorrowMapper;
import com.example.javeedemo.mapper.UserMapper;
import com.example.javeedemo.service.IBookService;
import com.example.javeedemo.service.IBorrowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@Slf4j
public class BorrowService implements IBorrowService {

    @Resource
    BorrowMapper borrowMapper;


    @Override
    public List<Borrow> list() {
        return borrowMapper.list();
    }

    @Override
    public PageInfo<Borrow> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        return new PageInfo<>(borrowMapper.listByCondition(baseRequest));

    }
    @Override
    public PageInfo<Borrow> page1(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        return new PageInfo<>(borrowMapper.listByCondition2(baseRequest));

    }

    @Override
    public void save(Borrow obj) {
        borrowMapper.save(obj);
    }

    @Override
    public Borrow getById(Integer id) {
        return borrowMapper.getById(id);
    }

    @Override
    public void update(Borrow obj) {
        obj.setUpdatetime(LocalDate.now());
        borrowMapper.updateById(obj);
    }

    @Override
    public void deleteById(Integer id) {
        borrowMapper.deleteById(id);
    }

    @Override
    public void update1(Integer id) {
        borrowMapper.update1(id);
    }

    @Override
    public void update2(Integer id) {

        borrowMapper.update2(id);
    }

    @Override
    public void update3(String statement, Integer id) {
        borrowMapper.update3(statement,id);
    }

    @Override
    public void update4(Integer id) {
        borrowMapper.update4(id);
    }

    @Override
    public PageInfo<Borrow> page2(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(), baseRequest.getPageSize());
        return new PageInfo<>(borrowMapper.listByCondition3(baseRequest));

    }

}
