package com.atguigu.spring5.outsidebean;

public class UserDaoImpl implements UserDao {
    @Override
    public void update() {
        System.out.println("dao update..............");
    }
}
