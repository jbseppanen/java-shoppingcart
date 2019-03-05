package com.lambdaschool.javashoppingcart.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Orderitem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderitemid;

    private int itemqty;
    private double price;

    @ManyToOne
    @JoinColumn(name = "productid")
    @JsonIgnoreProperties("orderitems")
    private Product product;


    @ManyToOne
    @JoinColumn(name = "orderid")
    @JsonIgnoreProperties("orders")
    private Order order;

    public Orderitem() {
    }

    public long getOrderitemid() {
        return orderitemid;
    }

    public void setOrderitemid(long orderitemid) {
        this.orderitemid = orderitemid;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getItemqty() {
        return itemqty;
    }

    public void setItemqty(int itemqty) {
        this.itemqty = itemqty;
    }
}
