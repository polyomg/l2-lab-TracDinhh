package com.poly.lab6.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import poly.edu.LAB6.Enity.Products;

public interface ProductDAO extends JpaRepository<Products, Integer> {
}
