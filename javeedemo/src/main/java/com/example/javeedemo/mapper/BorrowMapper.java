package com.example.javeedemo.mapper;

import com.example.javeedemo.controller.request.BaseRequest;
import com.example.javeedemo.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface BorrowMapper {

    List<Borrow> list();

    List<Borrow> listByCondition(BaseRequest baseRequest);

    void save(Borrow obj);

    Borrow getById(Integer id);

    void updateById(Borrow user);

    void deleteById(Integer id);
    void update1(Integer id);
    void update2(Integer id);
    void update3(String statement,Integer id);
    List<Borrow> listByCondition2(BaseRequest baseRequest);
    List<Borrow> listByCondition3(BaseRequest baseRequest);
    void update4(Integer id);
}
