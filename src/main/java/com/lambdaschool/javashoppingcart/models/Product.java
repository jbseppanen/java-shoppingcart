package com.lambdaschool.javashoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productid;
    private String name, description;
    private double price;
    private int qtyinstock;

    @ManyToMany(mappedBy = "products")
//    @JsonIgnoreProperties("products")
    @JsonIgnore
    private Set<Supplier> suppliers = new HashSet<>();

    @OneToMany(mappedBy = "product")
//    @JsonIgnoreProperties("product")
    @JsonIgnore
    private Set<Orderitem> orderitems = new HashSet<>();

    @OneToMany(mappedBy = "product")
//    @JsonIgnoreProperties("product")
    @JsonIgnore
    private Set<ShoppingItem> shoppingitems = new HashSet<>();

    public Product() {
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQtyinstock() {
        return qtyinstock;
    }

    public void setQtyinstock(int qtyinstock) {
        this.qtyinstock = qtyinstock;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Set<Orderitem> getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(Set<Orderitem> orderitems) {
        this.orderitems = orderitems;
    }

    public Set<ShoppingItem> getShoppingitems() {
        return shoppingitems;
    }

    public void setShoppingitems(Set<ShoppingItem> shoppingitems) {
        this.shoppingitems = shoppingitems;
    }
}
