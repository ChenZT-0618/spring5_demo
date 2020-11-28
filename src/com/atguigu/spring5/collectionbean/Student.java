package com.atguigu.spring5.collectionbean;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    // 数组类型属性
    private String[] courses;
    // list集合类型属性
    private List<String> list;
    // map集合类型属性
    private Map<String,String> map;
    // set集合类型属性
    private Set<String> set;

    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }
}
