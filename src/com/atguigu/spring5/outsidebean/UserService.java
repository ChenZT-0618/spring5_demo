package com.atguigu.spring5.outsidebean;

public class UserService {
    // 在service的add方法中调用UserDao的方法

    // 创建UserDao类型属性，生成set方法
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service add................");
        userDao.update();
    }
}
