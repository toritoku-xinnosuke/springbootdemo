package com.cjd.springbootdemo.service;

import com.cjd.springbootdemo.dao.TestTableDao;
import com.cjd.springbootdemo.domain.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTableService {

    @Autowired
    private TestTableDao testTableDao;

    public TestTable getByC1(String c1){
        return testTableDao.getByC1(c1);
    }

    @Transactional
    public boolean insert(){
        TestTable testTable = new TestTable();
        testTable.setC1("q");
        testTable.setC2(1);
        testTableDao.insert(testTable);
        return true;
    }
}
