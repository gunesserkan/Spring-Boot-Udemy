package com.gunes.aop.aspect;


import com.gunes.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {

    @Around("execution(* com.gunes.aop.service.*.getFortune(.. ))")
    public Object arroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("Around metod çalışıyor.");
        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception exc) {
            result = "continue";
        }
        long end = System.currentTimeMillis();
        long duration = end - begin;
        System.out.println("duration: " + duration);
        return result;
    }

    @After("execution(* com.gunes.aop.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> after finally method çalıştı");
    }


    @AfterThrowing(
            pointcut = "execution(* com.gunes.aop.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====> afterthrowing method çalıştı");
        System.out.println("-----------------");
        System.out.println("\n=====> Exception is:" + theExc);

    }


    @AfterReturning(
            pointcut = "execution(* com.gunes.aop.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====> After method çalıştı");


        System.out.println("\n=====> result is:" + result);
        convertAccountNamesToUpperCase(result);
        System.out.println("\n=====> result is:" + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        result.forEach(account ->
                account.setFirstName(
                        account.getFirstName().toUpperCase()
                )
        );
    }


    @Before("com.gunes.aop.aspect.MyAopExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n====> Execution before addAccountAdvice");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println(methodSignature);

        Object[] args = theJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println(account.getFirstName());
                System.out.println(account.getLastName());
            }
        }
    }


}
