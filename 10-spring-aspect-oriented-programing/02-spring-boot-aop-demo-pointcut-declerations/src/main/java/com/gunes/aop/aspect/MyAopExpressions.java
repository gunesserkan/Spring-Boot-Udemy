package com.gunes.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAopExpressions {

    @Pointcut("execution(*  com.gunes.aop.dao.*.*(..))")
    public void forDaoPackages() {
    }

    @Pointcut("execution(*  com.gunes.aop.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(*  com.gunes.aop.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("forDaoPackages() && !(getter() || setter()) ")
    public void forDAOPackageNoGetterSetter() {
    }
}
