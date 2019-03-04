package com.lambdaschool.javashoppingcart.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Suppliers {

    @Id
    @GeneratedValue
    private long supplierid;

    private String billingaddress, shippingaddress, city, state, phonenumber, paymethod;
}
