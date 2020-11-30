package com.atguigu.spring5.autowire;

public class Emp {
    private Dept dept_a;

    public void setDept(Dept dept) {
        this.dept_a = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept_a +
                '}';
    }

    public void test(){
        System.out.println(dept_a);
    }
}
