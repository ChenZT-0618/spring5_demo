package com.atguigu.spring5.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author ChenZT
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 少钱的方法
    public void reduceMoney() {
        String sql = "update account set money=money-? where username=?";
        jdbcTemplate.update(sql, 100, "Lucy");
    }

    // 多钱的方法
    @Override
    public void addMoney() {
        String sql = "update account set money=money+? where username=?";
        jdbcTemplate.update(sql, 100, "Mary");
    }
}
