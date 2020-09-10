package com.cjd.springbootdemo.controller;

import com.cjd.springbootdemo.utils.FreemarkerResource;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gypsophila
 */
@Log4j2
@Controller
@RequestMapping(value = "/ftl")
public class FreemarkerController {
    @Autowired
    private FreemarkerResource freemarkerResource;



    @RequestMapping(value = "index")
    public String index(ModelMap map){
        //log.info("now in FreemarkerController index");
        map.addAttribute("resource",freemarkerResource);
        return "freemarker/index";
    }

    @RequestMapping(value = "list")
    public String list(ModelMap map){
        //log.info("now in list");
        map.put("users",parseUsers());
        map.put("title","用户列表");

        return "freemarker/center";
    }

    private List<Map> parseUsers(){
        List<Map> list = new ArrayList<>();
        for (int i = 0 ; i < 10 ; ++i){
            Map map = new HashMap();
            map.put("name","chen" + i);
            map.put("age" , 10 + i);
            map.put("phone" , "1591000000");
            list.add(map);
        }
        return list;
    }
}
