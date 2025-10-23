package com.poly.lab7.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Khóa chính tự tăng

    @Column(nullable = false, length = 100)
    private String name; // Tên loại hàng

    // Quan hệ 1-N: 1 Category có nhiều Product
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    @Override
    public String toString() {
        return name;
    }

}
