package com.dengzhihong.controller;

import com.dengzhihong.domain.Book;
import com.dengzhihong.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        if (flag){
            return new Result(Code.SAVE_OK,null);
        }else {
            return new Result(Code.SAVE_ERR,null);
        }
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        if (flag){
            return new Result(Code.UPDATE_OK,null);
        }else {
            return new Result(Code.UPDATE_ERR,null);
        }
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean falg = bookService.delete(id);
        if (falg){
            return new Result(Code.DELETE_OK,null);
        }else {
            return new Result(Code.DELETE_ERR,null);
        }
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Book book = bookService.getById(id);
        if (book!=null){
            return new Result(Code.GET_OK,book);
        }else {
            return new Result(Code.GET_ERR,book);
        }

    }

    @GetMapping
    public Result getAll() {
        List<Book> bookList = bookService.getAll();
        if (bookList.size()>0){
            return new Result(Code.GET_OK,bookList);
        }else {
            return new Result(Code.GET_ERR,null);
        }
    }
}
