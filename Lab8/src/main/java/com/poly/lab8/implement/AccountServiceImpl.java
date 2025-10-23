package com.poly.lab8.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.Lab8.Dao.AccountDao;
import poly.edu.Lab8.Entity.Account;
import poly.edu.Lab8.Service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao dao;

    @Override
    public Account findById(String username) {
        return dao.findById(username).orElse(null);
    }
}