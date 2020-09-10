package com.cjd.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetConfigController {

    @Value("${name}")
    private String name;

    @Value("${baiduUrl}")
    private String baiduUrl;

    @Value("${content}")
    private String content;

    @RequestMapping("/baidu")
    public String getBaidu(){
        return name + " baidu " + baiduUrl;
    }

    @RequestMapping("content")
    public String getContent(){
        return content;
    }

}
