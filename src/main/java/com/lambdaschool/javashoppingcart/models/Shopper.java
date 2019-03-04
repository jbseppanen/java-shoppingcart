package com.lambdaschool.javashoppingcart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Shopper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shopperid;

    private String firstname, lastname, billingaddress, billingcity, billingstate, billingzip, shippingaddress, shippingcity, shippingstate, shippingzipcode, phonenumber, paymethod;

    @OneToMany(mappedBy = "shopper")
    @JsonIgnoreProperties("shopper")
    private Set<Order> orders;

    @OneToOne(mappedBy = "shopper")
    @JsonIgnoreProperties("shopper")
    private Cart cart;

    public Shopper() {
    }

    public long getShopperid() {
        return shopperid;
    }

    public void setShopperid(long shopperid) {
        this.shopperid = shopperid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    public String getBillingcity() {
        return billingcity;
    }

    public void setBillingcity(String billingcity) {
        this.billingcity = billingcity;
    }

    public String getBillingstate() {
        return billingstate;
    }

    public void setBillingstate(String billingstate) {
        this.billingstate = billingstate;
    }

    public String getBillingzip() {
        return billingzip;
    }

    public void setBillingzip(String billingzip) {
        this.billingzip = billingzip;
    }

    public String getShippingaddress() {
        return shippingaddress;
    }

    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress;
    }

    public String getShippingcity() {
        return shippingcity;
    }

    public void setShippingcity(String shippingcity) {
        this.shippingcity = shippingcity;
    }

    public String getShippingstate() {
        return shippingstate;
    }

    public void setShippingstate(String shippingstate) {
        this.shippingstate = shippingstate;
    }

    public String getShippingzipcode() {
        return shippingzipcode;
    }

    public void setShippingzipcode(String shippingzipcode) {
        this.shippingzipcode = shippingzipcode;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
