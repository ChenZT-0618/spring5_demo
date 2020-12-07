package com.atguigu.spring5.jdbcTemplate.dao;

import com.atguigu.spring5.jdbcTemplate.entity.Job;

/**
 * @author ChenZT
 */
public interface EmployeeDao {
    public void print();

    void add(Job job);
}
