package com.poly.lab6.Enity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Orderdetails")
public class Orderdetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double price;
    Integer quantity;
    @ManyToOne @JoinColumn(name = "Productid")
    Products product;
    @ManyToOne @JoinColumn(name = "Orderid")
    Orders order;
}
