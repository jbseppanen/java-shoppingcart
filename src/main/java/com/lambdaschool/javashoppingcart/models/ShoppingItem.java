package com.lambdaschool.javashoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "shoppingitem")
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shoppingitemid;

    private Product product;
    private int itemqty;

    @ManyToOne
    @JoinColumn(name = "cartid")
    @JsonIgnoreProperties("items")
    private Cart cart;

    public ShoppingItem() {
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
