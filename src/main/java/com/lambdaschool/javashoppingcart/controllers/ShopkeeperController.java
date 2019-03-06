package com.lambdaschool.javashoppingcart.controllers;

import com.lambdaschool.javashoppingcart.models.Product;
import com.lambdaschool.javashoppingcart.models.Supplier;
import com.lambdaschool.javashoppingcart.repositories.ProductRepository;
import com.lambdaschool.javashoppingcart.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ShopkeeperController {

    @Autowired
    SupplierRepository supplierRepo;

    @Autowired
    ProductRepository productRepo;

    @GetMapping(value = "/suppliers")
    public List<Supplier> listAllSuppliers() {
        return supplierRepo.findAll();
    }

    @PostMapping("/product")
    public Product addNewProduct(@RequestBody Product product) throws URISyntaxException {
        return productRepo.save(product);
    }
}
