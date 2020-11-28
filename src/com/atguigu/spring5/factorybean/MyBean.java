package com.atguigu.spring5.factorybean;

import com.atguigu.spring5.collectionbean.Course;
import org.springframework.beans.factory.FactoryBean;

// 第一步:创建类，让这个类作为工厂bean，实现接口FactoryBean
public class MyBean implements FactoryBean<Course> {

    // 第二步:实现接口里面的方法，在实现的方法中定义返回的bean类型
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("HelloWorld");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
