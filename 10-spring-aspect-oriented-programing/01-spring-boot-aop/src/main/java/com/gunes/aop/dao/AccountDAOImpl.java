package com.gunes.aop.dao;


import com.gunes.aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {
    @Override
    public void addAccount(Account theAccount, boolean isWhat) {
        System.out.println(theAccount.getFirstName() + " : " + theAccount.getLastName());
    }
}
