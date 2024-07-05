package com.example.javeedemo.controller;

import com.example.javeedemo.common.Result;
import com.example.javeedemo.controller.request.BorrowPageRequest;
import com.example.javeedemo.entity.Borrow;
import com.example.javeedemo.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    IBorrowService borrowService;

    @PostMapping("/save")
    public Result save(@RequestBody Borrow obj) {
        borrowService.save(obj);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Borrow obj) {
        borrowService.update(obj);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        borrowService.deleteById(id);
        return Result.success();
    }

    @DeleteMapping("/delete1/{id}")
    public Result delete1(@PathVariable Integer id) {
        borrowService.update1(id);
        return Result.success();
    }
    @DeleteMapping("/delete2/{id}")
    public Result delete2(@PathVariable Integer id) {
        borrowService.update2(id);
        return Result.success();
    }
    @DeleteMapping("/delete3/{id}/{value}")
    public Result delete3(@PathVariable Integer id,@PathVariable String value) {
        borrowService.update3(value,id);
        return Result.success();
    }
    @DeleteMapping("/delete4/{id}")
    public Result delete4(@PathVariable Integer id) {
        borrowService.update4(id);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Borrow obj = borrowService.getById(id);
        return Result.success(obj);
    }

    @GetMapping("/list")
    public Result list() {
        List<Borrow> list = borrowService.list();
        return Result.success(list);
    }

    @GetMapping("/page")
    public Result page(BorrowPageRequest pageRequest) {
        System.out.println(pageRequest);
        return Result.success(borrowService.page(pageRequest));
    }


    @GetMapping("/page2")
    public Result page2(BorrowPageRequest pageRequest) {
        return Result.success(borrowService.page1(pageRequest));
    }

    @GetMapping("/page3")
    public Result page3(BorrowPageRequest pageRequest) {
        return Result.success(borrowService.page2(pageRequest));
    }

}