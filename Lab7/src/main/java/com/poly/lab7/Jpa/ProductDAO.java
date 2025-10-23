package com.poly.lab7.Jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.edu.Lab7.Entity.Product;
import poly.edu.Lab7.Entity.Report;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Integer> {
    @Query("FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findByPrice(double minPrice, double maxPrice);

    //DSL
    List<Product> findByPriceBetween(double minPrice, double maxPrice);

    //DSL
    Page<Product> findAllByNameLike(String keywords, Pageable pageable);

    @Query("FROM Product o WHERE o.name LIKE ?1")
    Page<Product> findByKeywords(String keywords, Pageable pageable);

    @Query("SELECT o.category AS group, sum(o.price) AS sum, count(o) AS count "
            + "FROM Product o "
            + "GROUP BY o.category "
            + "ORDER BY sum(o.price) DESC")
    List<Report> getInventoryByCategory();
}
