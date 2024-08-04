package com.gunes.aop.dao;


import com.gunes.aop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("Exeption!!!");
        }
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("user1", "aaaa"));
        accounts.add(new Account("user2", "bbbb"));
        accounts.add(new Account("user3", "cccc"));


        return accounts;
    }

    @Override
    public void addAccount(Account theAccount, boolean isWhat) {
        System.out.println(theAccount.getFirstName() + " : " + theAccount.getLastName());
    }

    @Override
    public void doWork() {
        System.out.println("I'm doing work");
    }

    public String getName() {
        System.out.println("getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("getService()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
