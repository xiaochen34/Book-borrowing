package com.example.javeedemo.mapper;

import com.example.javeedemo.controller.request.BaseRequest;
import com.example.javeedemo.controller.request.UserPageRequest;
import com.example.javeedemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> list();

    List<User> listByCondition(BaseRequest baseRequest);

    void save(User user);

    User getById(Integer id);
    void updateById(User user);

    void deleteById(Integer id);

    User getByUsername(String userNo);
    void updateByName(String name);
    void updateByName1(String name);
}
