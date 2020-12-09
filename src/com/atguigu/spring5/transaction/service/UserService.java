package com.atguigu.spring5.transaction.service;

import com.atguigu.spring5.transaction.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ChenZT
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class UserService {
    // 注入DAO
    @Autowired
    private UserDao userDao;


    //转账的方法
    public void accountMoney() {
        //lucy 少 100
        userDao.reduceMoney();

        int i = 10 / 0;
        //mary 多 100
        userDao.addMoney();

    }
}
