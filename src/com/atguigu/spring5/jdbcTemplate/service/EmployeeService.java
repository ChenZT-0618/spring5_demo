package com.atguigu.spring5.jdbcTemplate.service;

import com.atguigu.spring5.jdbcTemplate.dao.EmployeeDao;
import com.atguigu.spring5.jdbcTemplate.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChenZT
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void add(Job job) {
        employeeDao.add(job);
    }
}
