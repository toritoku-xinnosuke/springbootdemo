package com.cjd.springbootdemo.dao;

import com.cjd.springbootdemo.domain.TestTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestTableDao {

    @Select("select * from t_test_table where c1 = #{c1}")
    public TestTable getByC1(@Param("c1") String c1);

    @Insert("insert into t_test_table(c1,c2) values(#{c1},#{c2})")
    public int insert(TestTable testTable);
}
