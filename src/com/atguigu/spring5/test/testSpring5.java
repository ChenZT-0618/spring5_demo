package com.atguigu.spring5.test;

import com.atguigu.spring5.Book;
import com.atguigu.spring5.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class testSpring5 {
    @Test
    public void testAdd() {
        // 加载配置文件
        ApplicationContext context = new FileSystemXmlApplicationContext("config.xml");
        // 通过配置文件创建对象
        User user = context.getBean("user", User.class);

        user.add();
    }

    @Test
    public void testBook() {
        ApplicationContext context = new FileSystemXmlApplicationContext("config.xml");
        Book book = context.getBean("book", Book.class);

        book.printBookInfo();
    }
}
