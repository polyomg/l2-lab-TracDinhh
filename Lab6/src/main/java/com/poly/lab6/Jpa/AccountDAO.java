package com.poly.lab6.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.LAB6.Enity.Accounts;

public interface AccountDAO extends JpaRepository<Accounts, String> {
}
