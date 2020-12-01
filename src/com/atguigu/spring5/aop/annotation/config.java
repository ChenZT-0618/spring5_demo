package com.atguigu.spring5.aop.annotation;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configurable
@ComponentScan(basePackages = {"com.atguigu.spring5.aop"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class config {
}
