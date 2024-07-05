package com.example.javeedemo.controller;

import com.example.javeedemo.common.Result;
import com.example.javeedemo.controller.request.BookPageRequest;
import com.example.javeedemo.entity.Book;
import com.example.javeedemo.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    IBookService bookService;

    @PostMapping("/save")
    public Result save(@RequestBody Book obj) {
        bookService.save(obj);
        return Result.success();
    }
    @PostMapping("/save2")
    public Result save2(@RequestBody Book obj) {
        bookService.save2(obj);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Book obj) {
        bookService.update(obj);
        return Result.success();
    }

    @PutMapping("/updateUpload/{id}")
    public Result updateUpload(@PathVariable Integer id) {
        bookService.updateUpload(id);
        return Result.success();
    }

    @PutMapping("/updateUpload1/{id}")
    public Result updateUpload1(@PathVariable Integer id) {
        bookService.updateUpload1(id);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        bookService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book obj = bookService.getById(id);
        return Result.success(obj);
    }

    @GetMapping("/list")
    public Result list() {
        List<Book> list = bookService.list();
        return Result.success(list);
    }

    @GetMapping("/page")
    public Result page(BookPageRequest pageRequest) {
        return Result.success(bookService.page(pageRequest));
    }

    @GetMapping("/page2")
    public Result page2(BookPageRequest pageRequest) {
        return Result.success(bookService.page2(pageRequest));
    }
    @DeleteMapping("/delete3/{id}/{value}")
    public Result delete3(@PathVariable Integer id,@PathVariable String value) {
        bookService.update3(value,id);
        return Result.success();
    }
}