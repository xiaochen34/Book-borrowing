package com.example.javeedemo.mapper;

import com.example.javeedemo.controller.request.*;
import com.example.javeedemo.entity.Admin;
import com.example.javeedemo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Mapper
public interface AdminMapper {
    List<Admin> list();

    List<Admin> listByCondition(BaseRequest baseRequest);

    void save(Admin obj);

    Admin getById(Integer id);
    void updateById(Admin obj);

    void deleteById(Integer id);

    Admin getByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
    User getByUsernameAndPassword2(@Param("username") String username, @Param("password") String password);
    int updatePassword(PasswordRequest request);
}