package com.gunes.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyAnalyticsAspect {
    @Before("com.gunes.aop.aspect.MyAopExpressions.forDAOPackageNoGetterSetter()")
    public void performAnalytics() {
        System.out.println("\n====> Performing API analytics");
    }
}
