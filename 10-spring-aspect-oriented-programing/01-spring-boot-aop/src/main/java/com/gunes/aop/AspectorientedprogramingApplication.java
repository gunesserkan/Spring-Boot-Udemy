package com.gunes.aop;

import com.gunes.aop.dao.AccountDAO;
import com.gunes.aop.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AspectorientedprogramingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AspectorientedprogramingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        return runner -> {
            demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
        };
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

        theAccountDAO.addAccount(new Account("Serkan", "Güneş"), true);
        System.out.println("\n Arada başka işlemler oldu");
        theMembershipDAO.addASillMember();
    }

}
