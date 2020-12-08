package com.atguigu.spring5.jdbcTemplate.dao;

import com.atguigu.spring5.jdbcTemplate.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public void updateJob(Job newJob) {
        String sql = "update jobs set job_title=?,min_salary=?,max_salary=? where job_id = ?";
        Object[] args = {newJob.getJob_title(),newJob.getMin_salary(), newJob.getMax_salary(),newJob.getJob_id()};
        int update = jdbcTemplate.update(sql, args);
        System.out.println(update);

    }

    @Override
    public void deleteJob(String job_id) {
        String sql = "delete from jobs where job_id =?";
        int update = jdbcTemplate.update(sql, job_id);
        System.out.println(update);
    }

    @Override
    public int count() {
        String sql = "select count(*) from jobs";
        // 参数1：sql语句；参数2：返回类型的类
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public Job findJobInfo(String id) {
        String sql = "select * from jobs where job_id =?";
        // 三个参数：sql语句，RowMapper接口，参数
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Job>(Job.class),id);
    }

    @Override
    public List<Job> findAll() {
        String sql = "select * from jobs";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Job>(Job.class));
    }

    @Override
    public void batchAdd(List<Object[]> batchArgs) {
        String sql = "insert into jobs values(?,?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, batchArgs);
        System.out.println(ints);
    }
}
