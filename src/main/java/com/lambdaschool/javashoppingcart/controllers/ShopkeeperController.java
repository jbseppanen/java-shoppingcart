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
import java.util.Optional;
import java.util.Set;

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

    @PostMapping(value = "/supplier/{supplierid}/product/{productid}")
    public Supplier addProductToSupplier(@PathVariable long supplierid, @PathVariable long productid) {
        Optional<Supplier> foundSupplier = supplierRepo.findById(supplierid);
        Optional<Product> foundProduct = productRepo.findById(productid);
        if (foundSupplier.isPresent() && foundProduct.isPresent()) {
            Supplier supplier = foundSupplier.get();
            Set<Product> products = supplier.getProducts();
            for (Product product : products) {
                if (product.getProductid() == productid) {
                    return null; //Supplier already present for this product
                }
            }
            supplier.getProducts().add(foundProduct.get());
            return supplierRepo.save(supplier);
        } else {
            return null; //Shopper or product not found
        }
    }

}
