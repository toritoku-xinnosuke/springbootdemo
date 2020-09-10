package com.cjd.springbootdemo.utils;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Gypsophila
 */
@Configuration
@ConfigurationProperties(prefix = "com.cjd.freemarkerdemo")
@PropertySource(value = "classpath:/resource/resource.properties",encoding = "utf-8")
public class FreemarkerResource {

    private String name;

    private String website;

    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


}
