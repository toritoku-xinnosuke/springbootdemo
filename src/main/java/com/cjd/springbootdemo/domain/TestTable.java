package com.cjd.springbootdemo.domain;

public class TestTable {
    private String c1;
    private int c2;

    @Override
    public String toString() {
        return "TestTable{" +
                "c1='" + c1 + '\'' +
                ", c2=" + c2 +
                ", c3='" + c3 + '\'' +
                '}';
    }

    private String c3;

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public int getC2() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    public String getC3() {
        return c3;
    }

    public void setC3(String c3) {
        this.c3 = c3;
    }
}
