package com.lambdaschool.javashoppingcart.controllers;

import com.lambdaschool.javashoppingcart.models.Shopper;
import com.lambdaschool.javashoppingcart.models.User;
import com.lambdaschool.javashoppingcart.repositories.ProductRepository;
import com.lambdaschool.javashoppingcart.repositories.ShopperRepository;
import com.lambdaschool.javashoppingcart.repositories.SupplierRepository;
import com.lambdaschool.javashoppingcart.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {


    @Autowired
    ProductRepository productRepo;

    @Autowired
    SupplierRepository supplierRepo;

    @Autowired
    ShopperRepository shopperRepo;

    @Autowired
    UserRepository userRepo;


    @GetMapping(value = "/shoppers")
    public List<Shopper> listAllShoppers() {
        return shopperRepo.findAll();
    }

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
