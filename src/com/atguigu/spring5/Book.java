package com.atguigu.spring5;

/**
 * 用于演示spring的依赖注入实现
 *
 * @author ChenZT
 */
public class Book {
    // 创建属性
    private String bname;
    private String bauthor;

    // 创建对应的set方法
    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    // 创建对应的有参构造方法
    public Book(String bname, String bauthor) {
        this.bname = bname;
        this.bauthor = bauthor;
    }

    public void printBookInfo() {
        System.out.println(bname + "::" + bauthor);
    }
}
