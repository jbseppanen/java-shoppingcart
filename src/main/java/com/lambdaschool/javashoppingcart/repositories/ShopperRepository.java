package com.lambdaschool.javashoppingcart.repositories;

import com.lambdaschool.javashoppingcart.models.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ShopperRepository extends JpaRepository<Shopper, Long> {

    @Transactional //Need both of these annotations to modify data.
    @Modifying
    @Query(value = "insert into shopper (firstname, lastname, billingaddress, billingcity, billingstate, billingzip, shippingaddress, shippingcity, shippingstate, shippingzipcode, phonenumber, paymethod) VALUES(:firstname, :lastname, :billingaddress, :billingcity, :billingstate, :billingzip, :shippingaddress, :shippingcity, :shippingstate, :shippingzipcode, :phonenumber, :paymethod)", nativeQuery = true)
    void addShopper(String firstname, String lastname, String billingaddress, String billingcity,
                    String billingstate, String billingzip, String shippingaddress, String shippingcity,
                    String shippingstate, String shippingzipcode, String phonenumber, String paymethod);

    Shopper findByFirstnameAndLastnameAndBillingaddress(String firstname, String lastname, String billingaddress);

//String string = "insert into shopper (firstname, lastname, billingaddress, billingcity, billingstate, billingzip, shippingaddress, shippingcity, shippingstate, shippingzipcode, phonenumber, paymethod) values (:firstname, :lastname, :billingaddress, :billingcity, :billingstate, :billingzip, :shippingaddress, :shippingcity, :shippingstate, :shippingzipcode, :phonenumber, :paymethod)";
}
