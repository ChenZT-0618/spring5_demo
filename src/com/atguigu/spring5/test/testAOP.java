package com.atguigu.spring5.test;

import com.atguigu.spring5.aop.annotation.User;
import com.atguigu.spring5.aop.xml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class testAOP {
    @Test
    public void testAop(){
        ApplicationContext context = new FileSystemXmlApplicationContext("aopConfig.xml");
        User user = context.getBean("user", User.class);
        user.add();
        System.out.println("**********************************************");
        user.min();

        System.out.println("**********************************************");
        Book book = context.getBean("book", Book.class);
        book.buy();
    }


}
