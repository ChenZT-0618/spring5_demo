package com.atguigu.spring5.annotation.service;

import com.atguigu.spring5.annotation.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ChenZT
 */
//在注解里面value属性值等同于bean中的id值，在这可以省略不写，
//默认值是类名称，首字母小写：UserService -- userService
@Service
public class UserService {
    //
    // @Autowired
    // @Qualifier(value = "userDaoImpl") // 要跟它的value相同：@Repository(value = "userDaoImpl")
    @Resource(name = "userDaoImpl")
    private UserDao userDao;


    public void add() {
        System.out.println("service add......");
        userDao.add();
    }
}
