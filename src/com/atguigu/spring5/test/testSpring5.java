package com.atguigu.spring5.test;

import com.atguigu.spring5.Book;
import com.atguigu.spring5.User;
import com.atguigu.spring5.insidebean.Emp;
import com.atguigu.spring5.outsidebean.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class testSpring5 {
    @Test
    public void testAdd() {
        // 加载配置文件
        ApplicationContext context = new FileSystemXmlApplicationContext("config.xml");
//        ApplicationContext context1 = new ClassPathXmlApplicationContext()
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

    @Test
    public void testService(){
        ApplicationContext context = new FileSystemXmlApplicationContext("config.xml");
        UserService userService =  context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void testEmp(){
        ApplicationContext context = new FileSystemXmlApplicationContext("config.xml");
        Emp emp = context.getBean("emp2",Emp.class);
        emp.print();
    }
}
