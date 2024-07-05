package com.example.javeedemo.mapper;

import com.example.javeedemo.controller.request.BaseRequest;
import com.example.javeedemo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    List<Book> list();

    List<Book> listByCondition(BaseRequest baseRequest);

    List<Book> listByCondition2(BaseRequest baseRequest);

    void save(Book obj);

    void updateUpload(Integer id);

    void updateUpload1(Integer id);

    Book getById(Integer id);

    void updateById(Book user);

    void deleteById(Integer id);


    void save2(Book obj);
    void update3(String statement,Integer id);
}