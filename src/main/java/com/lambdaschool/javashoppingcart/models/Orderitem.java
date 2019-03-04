package com.lambdaschool.javashoppingcart.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orderitem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shoppingitemid;

    private Product product;
    private int itemqty;

    public Orderitem() {
    }

    public long getShoppingitemid() {
        return shoppingitemid;
    }

    public void setShoppingitemid(long shoppingitemid) {
        this.shoppingitemid = shoppingitemid;
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
