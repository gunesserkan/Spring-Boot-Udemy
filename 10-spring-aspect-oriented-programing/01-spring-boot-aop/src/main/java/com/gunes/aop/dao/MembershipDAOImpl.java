package com.gunes.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {
    @Override
    public void addASillMember() {
        System.out.println("Running membership add account");
    }
}
