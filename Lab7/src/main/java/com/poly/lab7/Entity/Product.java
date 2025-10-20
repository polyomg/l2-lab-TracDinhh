package com.poly.lab7.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String name;

    private Double price;

    @Temporal(TemporalType.DATE)
    private Date createDate = new Date();

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;
}
