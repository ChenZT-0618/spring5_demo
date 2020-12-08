package com.atguigu.spring5.jdbcTemplate.dao;

import com.atguigu.spring5.jdbcTemplate.entity.Job;

import java.util.List;

/**
 * @author ChenZT
 */
public interface EmployeeDao {
    public void print();

    void add(Job job);

    void updateJob(Job job);

    void deleteJob(String job_id);

    int count();

    Job findJobInfo(String id);

    List<Job> findAll();

    void batchAdd(List<Object[]> batchArgs);
}
