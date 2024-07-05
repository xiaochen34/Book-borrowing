package com.example.javeedemo.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.log.Log;
import com.example.javeedemo.common.Result;
import com.example.javeedemo.controller.dto.LoginDTO;
import com.example.javeedemo.controller.request.BaseRequest;
import com.example.javeedemo.controller.request.LoginRequest;
import com.example.javeedemo.controller.request.PasswordRequest;
import com.example.javeedemo.entity.Admin;
import com.example.javeedemo.entity.User;
import com.example.javeedemo.exception.ServiceException;
import com.example.javeedemo.mapper.AdminMapper;
import com.example.javeedemo.mapper.UserMapper;
import com.example.javeedemo.service.IAservice;
import com.example.javeedemo.service.IUservice;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class AdminService implements IAservice {
    @Autowired
    AdminMapper adminMapper;
    private static final String DEFAULT_PASS="123";
    private static final String PASS_SALT="wew";

    @Override
    public List<Admin> list() {
        return adminMapper.list();
    }

    @Override
    public PageInfo<Admin> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Admin> users=adminMapper.listByCondition(baseRequest);
        return new PageInfo<>(users);
    }
    @Override
    public void save(Admin obj){
        if(StrUtil.isBlank(obj.getPassword())){
            obj.setPassword(DEFAULT_PASS);
        }
        obj.setPassword(securePass(obj.getPassword()));
        Date date= new Date();
        adminMapper.save(obj);

    }

    @Override
    public Admin getById(Integer id) {
        return adminMapper.getById(id);
    }


    @Override
    public void update(Admin user) {
        user.setUpdatetime(new Date());
        adminMapper.updateById(user);

    }

    @Override
    public void deleteById(Integer id) {
        adminMapper.deleteById(id);
    }

    @Override
    public LoginDTO login(LoginRequest request) {
            request.setPassword(securePass(request.getPassword()));
            Admin admin =adminMapper.getByUsernameAndPassword(request.getUsername(),request.getPassword());
            if(admin ==null){
                throw new ServiceException("密码错误");
            }
            LoginDTO loginDTO = new LoginDTO();
            BeanUtils.copyProperties(admin,loginDTO);
            return loginDTO;}

    @Override
    public void changePass(PasswordRequest request) {
        request.setNewPass(securePass(request.getNewPass()));
        int count = adminMapper.updatePassword(request);
        if (count <= 0) {
            throw new ServiceException("修改密码失败");
        }
    }

    @Override
    public LoginDTO login1(LoginRequest request) {
        User user =adminMapper.getByUsernameAndPassword2(request.getUsername(),request.getPassword());
        if(user ==null){
            throw new ServiceException("账号密码错误或账号已注销");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(user,loginDTO);
        return loginDTO;}


    private String securePass(String password){
        return SecureUtil.md5(password+PASS_SALT);
            }

    }