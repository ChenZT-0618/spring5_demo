package com.atguigu.spring5.test;

import com.atguigu.spring5.jdbcTemplate.entity.Job;
import com.atguigu.spring5.jdbcTemplate.service.EmployeeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author ChenZT
 */
public class testJdbcTemplate {
    @Test
    public void testAdd() {
        ApplicationContext context = new FileSystemXmlApplicationContext("JDBCConfig.xml");
        EmployeeService service = context.getBean("employeeService", EmployeeService.class);
        Job job = new Job();
        job.setJob_id("ST_MAN2");
        job.setJob_title("Stock Manager2");
        job.setMin_salary(2000);
        job.setMax_salary(3000);
        service.add(job);
    }
}
