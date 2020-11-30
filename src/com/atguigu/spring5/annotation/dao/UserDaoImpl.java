package com.atguigu.spring5.annotation.dao;

import org.springframework.stereotype.Repository;

/**
 * @author ChenZT
 */
@Repository(value = "userDaoImpl")
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao add........");
    }
}
