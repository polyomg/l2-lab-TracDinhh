package com.poly.lab8.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.Lab8.Entity.Account;

public interface AccountDao extends JpaRepository<Account, String> {
}
