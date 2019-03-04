package com.lambdaschool.javashoppingcart.controllers;

import com.lambdaschool.javashoppingcart.models.Product;
import com.lambdaschool.javashoppingcart.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    ProductRepository productRepo;

    @GetMapping(value = "/products")
    public List<Product> listAllProducts() {
        return productRepo.findAll();
    }

}
