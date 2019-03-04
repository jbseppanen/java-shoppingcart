package com.lambdaschool.javashoppingcart.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Data
@NoArgsConstructor

@Entity
public class Product {

    @Id
    @GeneratedValue
    private long productid;
    private String name, description;
    private double price;
    private int qty;

}
