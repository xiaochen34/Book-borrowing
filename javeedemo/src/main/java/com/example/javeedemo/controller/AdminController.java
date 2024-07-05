package com.example.javeedemo.controller;

import ch.qos.logback.classic.Logger;
import cn.hutool.log.Log;
import com.example.javeedemo.common.Result;
import com.example.javeedemo.controller.dto.LoginDTO;
import com.example.javeedemo.controller.request.AdminPageRequest;
import com.example.javeedemo.controller.request.LoginRequest;
import com.example.javeedemo.controller.request.PasswordRequest;
import com.example.javeedemo.entity.Admin;
import com.example.javeedemo.service.impl.AdminService;
import com.example.javeedemo.service.IAservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IAservice adminService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest request){
        LoginDTO login = adminService.login(request);
        return Result.success(login);
    }
    @PostMapping("/login1")
    public Result login1(@RequestBody LoginRequest request){
        LoginDTO login = adminService.login1(request);
        return Result.success(login);
    }
    @PutMapping("/password")
    public Result password(@RequestBody PasswordRequest request) {
        adminService.changePass(request);
        return Result.success();
    }

    @GetMapping("/list")
    public Result list(){
        List<Admin> list = adminService.list();
        return Result.success(list);
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Admin admin = adminService.getById(id);
        return Result.success(admin);
    }
    @PostMapping("/save")
    public Result save(@RequestBody Admin obj){

        adminService.save(obj);
        return Result.success();
    }
    @PutMapping("/update")
    public Result update(@RequestBody Admin obj){
        adminService.update(obj);
        return Result.success();
    }
    @GetMapping("/page")
    public Result page(AdminPageRequest pageRequest){

        return Result.success(adminService.page(pageRequest));
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        adminService.deleteById(id);
        return Result.success();
    }
}
