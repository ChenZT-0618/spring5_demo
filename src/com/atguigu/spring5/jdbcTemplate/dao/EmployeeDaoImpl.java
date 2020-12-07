package com.atguigu.spring5.jdbcTemplate.dao;

import com.atguigu.spring5.jdbcTemplate.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author ChenZT
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void print() {
        System.out.println("helloworld");
    }

    @Override
    public void add(Job job) {
        // 创建sql语句
        String sql = "insert into jobs values (?,?,?,?)";
        // 参数
        Object[] args = {job.getJob_id(), job.getJob_title(), job.getMin_salary(), job.getMax_salary()};
        // 用JdbcTemplate完成添加操作
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);
    }


}
