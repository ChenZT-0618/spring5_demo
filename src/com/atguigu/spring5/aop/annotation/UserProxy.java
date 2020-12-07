package com.atguigu.spring5.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 增强类，代理类
@Component
@Aspect
@Order(1)
public class UserProxy {

    // 相同切入点提取
    @Pointcut(value = "execution(* com.atguigu.spring5.aop.annotation.User.add(..))")
    public void pointExecution(){
        // 可以不写代码，表示execution路径
    }


    @Before(value = "pointExecution()")
    public void before(){
        System.out.println("before.........");
    }

    @After(value = "pointExecution()")
    public void after(){
        System.out.println("after..................");
    }
//    @AfterReturning
//    @AfterThrowing

    @Around(value = "execution(* com.atguigu.spring5.aop.annotation.User.min(..))")
    public void around(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("环绕前......................");
            joinPoint.proceed();
            System.out.println("环绕后......................");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
