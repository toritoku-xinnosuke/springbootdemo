package com.cjd.springbootdemo.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "author")
public class Author {
    private String name;

    private String baiduUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaiduUrl() {
        return baiduUrl;
    }

    public void setBaiduUrl(String baiduUrl) {
        this.baiduUrl = baiduUrl;
    }
}
