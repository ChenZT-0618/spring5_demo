package com.atguigu.spring5.aop.xml;

public class BookProxy {
    public void before(){
        System.out.println("Before........................");
    }

    public void after(){
        System.out.println("After..........................");
    }
}
