package com.atguigu.spring5.aop.annotation;


import org.springframework.stereotype.Component;

// 被增强类，被代理类
@Component
public class User {
    public void add(){
        System.out.println("add...........");
    }

    public void min(){
        System.out.println("min...........");
    }
}
