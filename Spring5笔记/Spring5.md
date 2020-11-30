Spring5

## IOC容器

### IOC概念和原理

1. 控制反转，把对象的创建和对象之间的调用过程，交给Spring管理
2. 目的：降低耦合度
3. 入门案例就是IOC实现

### IOC底层原理

<img src=".\原始模式.png" alt="原始模式" style="zoom:70%;" />

<img src="./工厂模式.png" style="zoom:67%;" />

<img src="./IOC过程.png" style="zoom:67%;" />

### IOC接口

提供了两个接口

1. BeanFactory：IOC的基本实现，是spring内部的使用接口，不提供给开发人员使用

   - 加载配置文件是不会创建对象，调用获取对象方法时才创建对象

2. ApplicationContext：BeanFactory的子接口，提供更多的功能，由开发人员使用

   - 加载配置文件时会创建对象。

3. ApplicationContext主要实现类：

   ![](.\主要实现类.png)

   - FileSystemXmlApplicationContext：
     - 没有盘符的是项目工作路径，即项目的根目录：src/...
     - 有盘符表示的是文件绝对路径.
   - ClassPathXmlApplicationContext：只能读放在web-info/classes目录下的配置文件

## IOC操作Bean管理

Bean管理，指的是两个操作：

- spring创建对象
- spring注入属性

Bean管理操作两个方式

- 基于xml配置文件方式实现
- 基于注解实现

### Bean管理：基于xml实现

- 基于 xml 方式创建对象

    ```xml
    <!--配置User对象-->
    <bean id="user" class="com.atguigu.spring5.User"></bean>
    ```

	在spring 配置文件中，使用 bean 标签，标签里面添加对应属性，就可以实现对象创建

	在bean标签有很多属性，介绍常用的属性

	* id 属性：唯一标识
	* class 属性：类全路径（包类路径）

	创建对象时候，默认也是执行无参数构造方法完成对象创建，**在创建类时一定要有一个无参构造**

- 基于xml方式注入属性

    DI：依赖注入，IOC中的一种实现，需要在创建对象的基础上完成。

    - **使用set方法注入**

      主要有两步：先创建对象，再注入属性
        ```Java
        // class类
        public class Book {
            // 创建属性
            private String bname;
            private String bauthor;

            // 创建对应的有参构造方法
            public Book(String bname, String bauthor) {
                this.bname = bname;
                this.bauthor = bauthor;
            }

            // 创建对应的set方法
            public void setBname(String bname) {
                this.bname = bname;
            }

            public void setBauthor(String bauthor) {
                this.bauthor = bauthor;
            }

            public void printBookInfo() {
                System.out.println(bname + "::" + bauthor);
            }
        }
        ```
        ```xml
        <!--使用set方法进行属性注入-->
        <bean id="book" class="com.atguigu.spring5.Book">
            <property name="bname" value="高等数学"></property>
            <property name="bauthor" value="高等教育出版社"></property>
        </bean>
        ```

    - **使用有参构造方法注入**
      
      - 创建类，定义属性，创建属性对应有参数构造方法
        ```xml
        <bean id="book" class="com.atguigu.spring5.Book">
            <!--使用有参构造方法进行属性注入-->
            <constructor-arg name="bname" value="abc"/>
            <constructor-arg name="bauthor" value="china"/>
        </bean>
        ```
      
    - **使用p空间进行注入简化**

      一、添加 p 名称空间在配置文件中

      二、进行属性注入，在 bean 标签里面进行操作： p:bname="cnd" p:bauthor="hhh"

      注：等同于使用set方法注入，只是简化了代码而已。

      ```xml
      <?xml version="1.0" encoding="UTF-8"?>
      <beans xmlns="http://www.springframework.org/schema/beans"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xmlns:p="http://www.springframework.org/schema/p"
             xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
          <!--配置User对象-->
          <bean id="user" class="com.atguigu.spring5.User"/>
      
          
          <bean id="book" class="com.atguigu.spring5.Book" p:bname="cnd" p:bauthor="hhh">
              <!--使用有参构造方法进行属性注入-->
              <constructor-arg name="bname" value="abc"/>
              <constructor-arg name="bauthor" value="china"/>
          </bean>
      </beans>
      ```


#### xml 注入其他类型属性

1. 字面量

   - null值

     ```xml
     <property name="bauthor" >
         <null/>
     </property>
     ```

   - 特殊符号：使用xml特有的格式 --  \<![CDATA[内容]]>

     ```xml
     <property name="bname">
         <value><![CDATA[《高等数学》]]></value>
     </property>
     ```

2. 外部bean，其他类

   创建两个类service和dao类，在service的方法中调用dao的方法

   ```java
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
   ```

   ```xml
   <!-- 创建service和dao对象，接口不能作为对象，需要找它的实现类 -->
   <bean id="UserDaoImpl" class="com.atguigu.spring5.dao.UserDaoImpl"/>
   <bean id="userService" class="com.atguigu.spring5.service.UserService">
       <!-- 注入dao对象
               name：service类中的属性名称
               ref：创建userDao对象的bean标签的ID值
           -->
       <property name="userDao" ref="UserDaoImpl"/>
   </bean>
   ```

3. 内部bean

   使用员工和部门的例子来解释

   ```xml
   <!-- 内部bean-->
   <bean id="emp" class="com.atguigu.spring5.insidebean.Emp">
       <property name="ename" value="lucy"/>
       <property name="gender" value="女"/>
       <property name="dept">
        	<!-- name和id没有特别的联系-->   
           <bean id="dept" class="com.atguigu.spring5.insidebean.Dept">
               <property name="dname" value="安保部"/>
           </bean>
       </property>
   </bean>
   ```

4. 级联赋值

   ```xml
   <!-- 级联赋值-->
   <bean id="emp2" class="com.atguigu.spring5.insidebean.Emp">
       <property name="ename" value="Mike"/>
       <property name="gender" value="男"/>
       <!-- 需要先注入Dept类-->
       <property name="dept" ref="dept2"/>
       <!-- 然后通过Emp提供的getDept方法，得到Dept对象-->
       <property name="dept.dname" value="技术部"/>
   </bean>
   <bean id="dept2" class="com.atguigu.spring5.insidebean.Dept"/>
   ```

#### xml 注入集合属性

注入数组、List集合、Map集合、Set集合类型的属性

1. 创建类，定义数组、list、map、set 类型属性，生成对应 set 方法

   ```java
   public class Student {
       // 数组类型属性
       private String[] courses;
       // list集合类型属性
       private List<String> list;
       // map集合类型属性
       private Map<String,String> map;
       // set集合类型属性
       private Set<String> set;
   
       
       public void setSet(Set<String> set) {
           this.set = set;
       }
   
       public void setList(List<String> list) {
           this.list = list;
       }
   
       public void setMap(Map<String, String> map) {
           this.map = map;
       }
   
       public void setCourses(String[] courses) {
           this.courses = courses;
       }
   }
   ```

2. 在spring 配置文件进行配置

   ```xml
   <!-- 注入集合类型属性-->
   <bean id="student" class="com.atguigu.spring5.collectionbean.Student">
       <!-- 数组类型-->
       <property name="courses">
           <array>
               <value>语文</value>
               <value>数学</value>
               <value>英语</value>
           </array>
       </property>
       <!-- list类型-->
       <property name="list">
           <list>
               <value>张三</value>
               <value>小三</value>
           </list>
       </property>
       <!-- map类型-->
       <property name="map">
           <map>
               <entry key="JAVA" value="java"/>
               <entry key="PHP" value="php"/>
           </map>
       </property>
       <!-- set类型赋值-->
       <property name="set">
           <set>
               <value>MySQL</value>
               <value>Redis</value>
           </set>
       </property>
   </bean>
   ```

3. class类集合注入

   ```xml
   <bean id="student" class="com.atguigu.spring5.collectionbean.Student">
       <!-- List类型赋值，但是值是对象，需要用外部引用的方式-->
       <property name="courseList">
           <list>
               <ref bean="course1"/>
               <ref bean="course2"/>
           </list>
       </property>
   </bean>
   
   <!-- 创建多个course对象 -->
   <bean id="course1" class="com.atguigu.spring5.collectionbean.Course">
       <property name="cname" value="政治"/>
   </bean>
   <bean id="course2" class="com.atguigu.spring5.collectionbean.Course">
       <property name="cname" value="历史"/>
   </bean>
   ```

4. 公共部分提取

   - 在spring 配置文件中引入名称空间 util

   主要以下两语句：
   
   - xmlns:util="http://www.springframework.org/schema/util" 
   - http://www.springframework.org/schema/util     http://www.springframework.org/schema/util/spring-util.xsd
   
   ```xml
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:p="http://www.springframework.org/schema/p"
          xmlns:util="http://www.springframework.org/schema/util"
          xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                              http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">
   </beans>
   ```

   
   - 使用 util 标签完成 list 集合注入提取
   
   ```xml
   <util:list id="courseList">
       <value>张三</value>
       <value>小三</value>
   </util:list>
   <property name="list" ref="courseList"></property>
   ```

    util 标签的其他集合

   ![util标签](./util类.png)



### Bean管理：工厂bean

Spring有两种类型 bean，一种普通 bean，另外一种工厂 bean（FactoryBean）

- 普通 bean ：在配置文件中定义 bean 类型就是返回类型

- 工厂 bean ：在配置文件定义 bean 类型可以和返回类型不一样，you

  - 要实现FactoryBean接口，并通过实现该接口中的getObject()方法来返回其他类型的bean

  - 注：在使用Context的getBean方法时，第二个参数要填写返回的那个类型

    ```java
    ApplicationContext context = new FileSystemXmlApplicationContext("config.xml");
    Course course = context.getBean("mybean", Course.class);
    System.out.println(course);
    ```

```java
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

```

```xml
<!--工厂bean-->
<bean id="mybean" class="com.atguigu.spring5.factorybean.MyBean"/>
```

### Bean管理：bean作用域

在 Spring 里面，可以设置创建 bean 实例是单实例还是多实例

默认情况下， 默认情况下，bean 是单实例对象

```java
@Test
public void testEmp(){
    ApplicationContext context = new FileSystemXmlApplicationContext("config.xml");
    Emp emp = context.getBean("emp2",Emp.class);
    Emp emp2 = context.getBean("emp2",Emp.class);
    
    System.out.println(emp); // com.atguigu.spring5.insidebean.Emp@70a9f84e
    System.out.println(emp2); // com.atguigu.spring5.insidebean.Emp@70a9f84e
}
```

如何设置单实例还是多实例：在 spring 配置文件 bean 标签里面有属性（scope）用于设置单实例还是多实例

```xml
<bean id="emp2" class="com.atguigu.spring5.insidebean.Emp" scope="prototype"></bean>
<bean id="emp2" class="com.atguigu.spring5.insidebean.Emp" scope="singleton"></bean>
```

singleton 和 prototype 区别

- scope 值是singleton 时候，加载 spring 配置文件时候就会创建单实例对象
- scope 值是 prototype 时候，不是在加载 spring 配置文件时候创建 对象，在调用getBean 方法时候创建多实例对象

### Bean管理：生命周期

无后置处理器，bean 生命周期有wu步

1. 通过构造器创建 bean 实例（无参数构造）
2. 为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
3. 调用 bean 的初始化的方法（**需要进行配置初始化的方法**）
4. bean 可以使用了（对象获取到了）
5. 当容器关闭时候，调用 bean 的销毁的方法（**需要进行配置销毁的方法**）

```java
public class Order {
    private String oname;
    
    public Order() {
        System.out.println("第一步 执行无参数构造创建bean实例");
    }
    
    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步 调用set方法设置属性值");
    }

 
    //创建执行的初始化的方法
    public void initMethod() {
        System.out.println("第三步 执行初始化的方法");
    }

    //创建执行的销毁的方法
    public void destroyMethod() {
        System.out.println("第五步 执行销毁的方法");
    }
}

@Test
public void testLifeCycle(){
    ApplicationContext context = new FileSystemXmlApplicationContext("config.xml");
    Order order = context.getBean("order", Order.class);
    System.out.println("第四步 获取创建bean实例对象");
    System.out.println(order);
    // 手动销毁
    ((FileSystemXmlApplicationContext)context).close();
}
```

```xml
<!--bean生命周期-->
<bean id="order" class="com.atguigu.spring5.lifecycle.Order"
      init-method="initMethod"
      destroy-method="destroyMethod">
    <property name="oname" value="手机"/>
</bean>
```

有后置处理器，bean 生命周期有七步

**如果有个类实现了BeanPostProcessor，那么在配置文件中该bean会对你当前配置文件中的所有bean都添加后置处理器**

1. 通过构造器创建 bean 实例（无参数构造）
2. 为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
3. 把 n bean 实例传递 n bean 后置处理器的方法 postProcessBeforeInitialization
4. 调用 bean 的初始化的方法（需要进行配置初始化的方法）
5. 把 bean 实例传递 bean 后置处理器的方法 postProcessAfterInitialization
6. bean 可以使用了（对象获取到了）
7. 当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）

```java
public class myPostProcessor implements BeanPostProcessor {
    // BeanPostProcessor有默认方法


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化之前执行的方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化之后执行的方法");
        return bean;
    }
}
```

```xml
<!--后置处理器，添加之后上面所有bean都会认为添加了后置处理器-->
<bean id="myPostBean" class="com.atguigu.spring5.lifecycle.myPostProcessor"/>
```

想到个问题，这些都是静态输入，有没有动态输入的方法

### Bean管理：自动装配

根据指定装配规则（属性名称或者属性类型），Spring 自动将匹配的属性值进行注入

两种自动装配方法：

- byName 根据属性名称注入 ，注入值 bean 的 id 值和类属性名称一样
- byType 根据属性类型注入

![](./自动装配.png)

```java
public class Emp {
    private Dept dept_a;

    public void setDept(Dept dept) {
        this.dept_a = dept;
    }
}
```

```xml
<bean id="emp_a" class="com.atguigu.spring5.autowire.Emp" autowire="byName"/>
<bean id="dept_a" class="com.atguigu.spring5.autowire.Dept"/>

<bean id= "emp_a" class= "com.atguigu.spring5.autowire.Emp" autowire= "byType"></ bean>
< bean id= "dept_a" class= "com.atguigu.spring5.autowire.Dept"></bean>
```

### Bean管理：引入外部文件

直接配置数据库信息