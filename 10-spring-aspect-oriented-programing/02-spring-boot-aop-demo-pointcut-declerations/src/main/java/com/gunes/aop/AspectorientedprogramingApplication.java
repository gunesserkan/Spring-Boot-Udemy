package com.gunes.aop;

import com.gunes.aop.dao.AccountDAO;
import com.gunes.aop.dao.MembershipDAO;
import com.gunes.aop.service.TheTrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AspectorientedprogramingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AspectorientedprogramingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO, TheTrafficFortuneService theTrafficFortuneService) {
        return runner -> {
//            demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
//            demoTheAfterReturningAdvice(theAccountDAO);
//            demoTheAfterThrowingAdvice(theAccountDAO);
//            demoTheAfterAdvice(theAccountDAO);
//            demoTheArroundAdvice(theTrafficFortuneService);
            demoTheAroundAdviceHandleException(theTrafficFortuneService);
        };
    }

    private void demoTheAroundAdviceHandleException(TheTrafficFortuneService theTrafficFortuneService) {
        System.out.println("Main program: demoTheAroundAdviceHandleException");
        System.out.println("Calling getFortune()");

        boolean tripWire = true;
        String data = theTrafficFortuneService.getFortune(tripWire);

        System.out.println("my fortune is: " + data);
        System.out.println("Finished");
    }

    private void demoTheArroundAdvice(TheTrafficFortuneService theTrafficFortuneService) {
        System.out.println("Main program: demoTheArroundAdvice");
        System.out.println("Calling getFortune()");

        String data = theTrafficFortuneService.getFortune();

        System.out.println("my fortune is: " + data);
        System.out.println("Finished");
    }

    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
        List<Account> accounts = null;
        try {
            boolean tripWire = false;
            theAccountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("Main program: caught exception " + e);
        }

        System.out.println("\n\n Main program: demoTheReturningAdvice");
        System.out.println("------");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
        List<Account> accounts = null;
        try {
            boolean tripWire = true;
            theAccountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("Main program: caught exception " + e);
        }

        System.out.println("\n\n Main program: demoTheReturningAdvice");
        System.out.println("------");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
        List<Account> accounts = theAccountDAO.findAccounts();

        System.out.println("\n\n Main program: demoTheReturningAdvice");
        System.out.println("------");
        System.out.println(accounts);
        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

        theAccountDAO.addAccount(new Account("Serkan", "Güneş"), true);
        theAccountDAO.doWork();

        theAccountDAO.setName("deneme");
        theAccountDAO.setServiceCode("12345");
        theAccountDAO.getName();
        theAccountDAO.getServiceCode();


        theMembershipDAO.addASillMember();
        theMembershipDAO.doSleep();
    }

}
