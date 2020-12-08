package com.atguigu.spring5.jdbcTemplate.service;

import com.atguigu.spring5.jdbcTemplate.dao.EmployeeDao;
import com.atguigu.spring5.jdbcTemplate.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // 修改方法
    public void updateJob(Job job){
        employeeDao.updateJob(job);
    }
    // 删除方法
    public void deleteJob(String job_id){
        employeeDao.deleteJob(job_id);
    }

    // 查询记录数
    public int findCount(){
       return employeeDao.count();
    }

    // 查询返回对象
    public Job findOne(String id){
        return employeeDao.findJobInfo(id);
    }

    // 查询返回集合
    public List<Job> findAll(){
        return employeeDao.findAll();
    }

    // 批量添加
    public void batchAdd(List<Object[]> batchArgs){
        employeeDao.batchAdd(batchArgs);
    }
}
