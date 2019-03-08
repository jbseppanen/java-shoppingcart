package com.lambdaschool.javashoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartid;

    @OneToMany(mappedBy = "cart")
    @JsonIgnoreProperties("cart")
    private Set<ShoppingItem> items;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "cartid")
    private Shopper shopper;

    public Cart() {
    }

    public long getCartid() {
        return cartid;
    }

    public void setCartid(long cartid) {
        this.cartid = cartid;
    }

    public Set<ShoppingItem> getItems() {
        return items;
    }

    public void setItems(Set<ShoppingItem> items) {
        this.items = items;
    }

    public Shopper getShopper() {
        return shopper;
    }

    public void setShopper(Shopper shopper) {
        this.shopper = shopper;
    }

    @JsonIgnore
    public Order getAsOrder() {
        Order order = new Order();
        Set<Orderitem> orderitems = new HashSet<>();
        for (ShoppingItem item : items) {
            orderitems.add(item.getAsOrderItem());
        }
        order.setItems(orderitems);
        order.setShopper(shopper);
        return order;
    }
}
