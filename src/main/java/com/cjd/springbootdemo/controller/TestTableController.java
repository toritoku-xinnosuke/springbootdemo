package com.cjd.springbootdemo.controller;

import com.cjd.springbootdemo.domain.TestTable;
import com.cjd.springbootdemo.service.TestTableService;
import com.mysql.cj.xdevapi.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestTableController {

    @Autowired
    TestTableService testTableService;

    @RequestMapping("/db/get")
    //@RequestBody
    public String dbGet(){
        TestTable testTable = testTableService.getByC1("t");
        System.out.println(testTable.toString());
        return testTable.toString();
    }

    @RequestMapping("/db/insert")
    public String dbInsert(){
        testTableService.insert();
        return "success";
    }


}
