package com.atguigu.spring5.test;

import com.atguigu.spring5.annotation.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author ChenZT
 */
public class testAnnotation {
    @Test
    public void test1() {
        ApplicationContext context = new FileSystemXmlApplicationContext("annotationConfig.xml");
        UserService service = context.getBean("userService", UserService.class);
        System.out.println(service);
        service.add();

    }
}
