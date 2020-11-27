package com.atguigu.spring5.insidebean;

public class Emp {
    private String ename;
    private String gender;
    private Dept dept;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    public void print(){
        System.out.println(ename+"::"+gender+"::"+dept);
    }
}
