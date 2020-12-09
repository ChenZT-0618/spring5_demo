package com.atguigu.spring5.test;

import com.atguigu.spring5.transaction.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author ChenZT
 */
public class testTransaction {
    @Test
    public void test() {
        ApplicationContext context = new FileSystemXmlApplicationContext("transactionConfig.xml");
        UserService service = context.getBean("userService", UserService.class);
        service.accountMoney();
    }
}
