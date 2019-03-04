package com.lambdaschool.javashoppingcart.controllers;

import com.lambdaschool.javashoppingcart.models.Product;
import com.lambdaschool.javashoppingcart.models.Shopper;
import com.lambdaschool.javashoppingcart.models.Supplier;
import com.lambdaschool.javashoppingcart.repositories.ProductRepository;
import com.lambdaschool.javashoppingcart.repositories.ShopperRepository;
import com.lambdaschool.javashoppingcart.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
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

    @GetMapping(value = "/products")
    public List<Product> listAllProducts() {
        return productRepo.findAll();
    }

    @GetMapping(value = "/suppliers")
    public List<Supplier> listAllSuppliers() {
        return supplierRepo.findAll();
    }

    @GetMapping(value = "/shoppers")
    public List<Shopper> listAllShoppers() {
        return shopperRepo.findAll();
    }

    @PostMapping("/product")
    public Product addNewProduct(@RequestBody Product product) throws URISyntaxException {
        return productRepo.save(product);
    }
}
