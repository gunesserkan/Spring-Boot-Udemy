package com.gunes.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
    @Before("com.gunes.aop.aspect.MyAopExpressions.forDAOPackageNoGetterSetter()")
    public void logToCloud() {
        System.out.println("\n====> Logging to cloud");
    }
}
