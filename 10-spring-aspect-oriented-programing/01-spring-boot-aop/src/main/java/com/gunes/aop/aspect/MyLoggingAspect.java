package com.gunes.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

    @Before("execution(*  com.gunes..add*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====> Execution before addAccountAdvice");
    }
}
