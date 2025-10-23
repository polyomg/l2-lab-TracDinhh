package com.poly.lab6.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.LAB6.Enity.Orderdetails;

public interface OrderDetailDAO extends JpaRepository<Orderdetails, Long> {
}
