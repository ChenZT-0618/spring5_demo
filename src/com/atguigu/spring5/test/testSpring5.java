package com.atguigu.spring5.test;

import com.atguigu.spring5.Book;
import com.atguigu.spring5.User;
import com.atguigu.spring5.collectionbean.Course;
import com.atguigu.spring5.collectionbean.Student;
import com.atguigu.spring5.insidebean.Emp;
import com.atguigu.spring5.lifecycle.Order;
import com.atguigu.spring5.outsidebean.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;

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
        Emp emp2 = context.getBean("emp2",Emp.class);
        emp.print();
        System.out.println(emp); // com.atguigu.spring5.insidebean.Emp@70a9f84e
        System.out.println(emp2); // com.atguigu.spring5.insidebean.Emp@70a9f84e
    }

    @Test
    public void testStu(){
        ApplicationContext context = new FileSystemXmlApplicationContext("config.xml");
        Student stu = context.getBean("student", Student.class);
        System.out.println(Arrays.toString(stu.getCourses()));
        System.out.println(stu.getList());
        System.out.println(stu.getMap());
        System.out.println(stu.getSet());
        System.out.println(stu.getCourseList());
    }

    @Test
    public void testFactoryBean(){
        ApplicationContext context = new FileSystemXmlApplicationContext("config.xml");
        Course course = context.getBean("mybean", Course.class);
        Course course2 = context.getBean("mybean", Course.class);

        System.out.println(course);
        System.out.println(course2);


    }

    @Test
    public void testLifeCycle(){
        ApplicationContext context = new FileSystemXmlApplicationContext("config.xml");
        Order order = context.getBean("order", Order.class);
        System.out.println("第四步 获取创建bean实例对象");
        System.out.println(order);
        // 手动销毁
        ((FileSystemXmlApplicationContext)context).close();
    }

    @Test
    public void testAutoWire(){
        ApplicationContext context = new FileSystemXmlApplicationContext("config.xml");
        com.atguigu.spring5.autowire.Emp emp = context.getBean("emp_a", com.atguigu.spring5.autowire.Emp.class);

        System.out.println(emp);
    }

}
