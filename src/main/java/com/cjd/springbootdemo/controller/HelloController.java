package com.cjd.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {

    @Autowired
    private Author author;

    @RequestMapping("hello")
    public String hello(){
        return "hello spring boot";
    }

    @RequestMapping("author")
    public String author(){
        return author.getName() + " " + author.getBaiduUrl();
    }
}





