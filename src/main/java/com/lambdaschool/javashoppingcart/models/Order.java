package com.lambdaschool.javashoppingcart.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderid;

    private int shippedstatus;

    @ManyToOne
    @JoinColumn(name = "shopperid")
    @JsonIgnoreProperties("orders")
    private Shopper shopper;

    @OneToMany(mappedBy = "order")
    @JsonIgnoreProperties("order")
    private Set<Orderitem> items;

    public Order() {
    }

    public long getOrderid() {
        return orderid;
    }

    public void setOrderid(long orderid) {
        this.orderid = orderid;
    }

    public Set<Orderitem> getItems() {
        return items;
    }

    public void setItems(Set<Orderitem> items) {
        this.items = items;
    }

    public int getShippedstatus() {
        return shippedstatus;
    }

    public void setShippedstatus(int shippedstatus) {
        this.shippedstatus = shippedstatus;
    }

    public Shopper getShopper() {
        return shopper;
    }

    public void setShopper(Shopper shopper) {
        this.shopper = shopper;
    }
}
