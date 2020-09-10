package com.cjd.springbootdemo.utils;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.util.JdbcConstants;

import java.util.List;

public class SqlParser {
    private static List<SQLStatement> getSQLStatementList(String sql) {
        String dbType = JdbcConstants.MYSQL;
        return SQLUtils.parseStatements(sql, dbType);
    }

    public static void main(String[] args) {
        String sql = "select age a,name n from student s inner join (select id,name from score where sex='女') temp on sex='男' and temp.id in(select id from score where sex='男') where student.name='zhangsan' group by student.age order by student.id ASC;";
        System.out.println("SQL语句为：" + sql);
        //格式化输出
        String result = SQLUtils.format(sql, JdbcConstants.MYSQL);
        System.out.println("格式化后输出：\n" + result);
        System.out.println("*********************");
        List<SQLStatement> sqlStatementList = getSQLStatementList(sql);
        //默认为一条sql语句
        SQLStatement stmt = sqlStatementList.get(0);
        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        stmt.accept(visitor);
        System.out.println("数据库类型\t\t" + visitor.getDbType());

        //获取字段名称
        System.out.println("查询的字段\t\t" + visitor.getColumns());

        //获取表名称
        System.out.println("表名\t\t\t" + visitor.getTables().keySet());

        System.out.println("条件\t\t\t" + visitor.getConditions());

        System.out.println("group by\t\t" + visitor.getGroupByColumns());

        System.out.println("order by\t\t" + visitor.getOrderByColumns());


    }
}