package com.example.javeedemo.controller;

import com.example.javeedemo.common.Result;
import com.example.javeedemo.controller.request.UserPageRequest;
import com.example.javeedemo.entity.User;
import com.example.javeedemo.service.IUservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUservice userService;



    @GetMapping("/list")
    public Result list(){
        List<User> users = userService.list();
        return Result.success(users);
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        User user = userService.getById(id);
        return Result.success(user);
    }
    @PostMapping("/save")
    public Result save(@RequestBody User user){

        userService.save(user);
        return Result.success();
    }
    @PutMapping("/update")
    public Result update(@RequestBody User user){

        userService.update(user);
        return Result.success();
    }
    @PutMapping("/update2/{name}")
    public Result update2(@PathVariable String name){
        userService.update1(name);
        return Result.success();
    }
    @PutMapping("/update3/{name}")
    public Result update3(@PathVariable String name){
        userService.update2(name);
        return Result.success();
    }
    @GetMapping("/page")
    public Result page(UserPageRequest userPageRequest){
        return Result.success(userService.page(userPageRequest));
    }
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id){
        userService.deleteById(id);
        return Result.success();
    }
}
