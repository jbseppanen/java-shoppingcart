package com.lambdaschool.javashoppingcart.controllers;

import com.lambdaschool.javashoppingcart.models.*;
import com.lambdaschool.javashoppingcart.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingController {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    ShopperRepository shopperRepo;

    @Autowired
    CartRepository cartRepo;

    @Autowired
    ShoppingitemRepository shoppingitemRepo;

    @Autowired
    OrderRepository orderRepo;

    @GetMapping(value = "/products")
    public List<Product> listAllProducts() {
        return productRepo.findAll();
    }

    @GetMapping(value = "/shopper/{shopperid}/cart")
    public ArrayList<Product> getShopperCart(@PathVariable long shopperid) {
        Optional<Shopper> foundShopper = shopperRepo.findById(shopperid);
        if (foundShopper.isPresent()) {
            Cart cart = foundShopper.get().getCart();
            if (cart == null) {
                cart = new Cart();
                cart.setShopper(foundShopper.get());
                cartRepo.save(cart);
            }
            ArrayList<Product> products = new ArrayList<>();
            if (cart.getItems() != null) {
                for (ShoppingItem item : cart.getItems()) {
                    Product product = item.getProduct();
                    product.setQtyinstock(item.getItemqty());
                    products.add(product);
                }
            }

            return products;
        }
        return null;
    }

    @PostMapping(value = "/shopper/{shopperid}/product/{productid}")
    public ShoppingItem addProductToCart(@PathVariable long shopperid, @PathVariable long productid) {
        Optional<Shopper> foundShopper = shopperRepo.findById(shopperid);
        Optional<Product> foundProduct = productRepo.findById(productid);
        if (foundShopper.isPresent() && foundProduct.isPresent()) {
            Cart cart = foundShopper.get().getCart();
            if (cart != null) {
                Set<ShoppingItem> items = cart.getItems();
                for (ShoppingItem item : items) {
                    if (item.getProduct().getProductid() == productid) {
                        if (item.getItemqty() >= item.getProduct().getQtyinstock()) {
                            return null; //Cannot get more than is in stock
                        }
                        item.setItemqty(item.getItemqty() + 1);
                        return shoppingitemRepo.save(item);
                    }
                }
            } else {
                cart = new Cart();
                cart.setShopper(foundShopper.get());
                cartRepo.save(cart);
            }
            ShoppingItem itemToAdd = new ShoppingItem();
            itemToAdd.setCart(cart);
            Product product = foundProduct.get();
            itemToAdd.setProduct(product);
            itemToAdd.setItemqty(1);
            return shoppingitemRepo.save(itemToAdd);
        } else {
            return null; //Shopper or product not found
        }
    }

    @PostMapping(value = "/shopper/{shopperid}/order")
    public Order orderItemsInCart(@PathVariable long shopperid) {
        Optional<Shopper> foundShopper = shopperRepo.findById(shopperid);
        Order order = null;
        if (foundShopper.isPresent()) {
            Shopper shopper = foundShopper.get();
            Cart cart = shopper.getCart();
            if (cart != null) {
                Set<ShoppingItem> items = cart.getItems();
                if (items != null) {
                    order = cart.getAsOrder();
                    order.setShippedstatus(0);
                    order = orderRepo.save(order);
                    for (ShoppingItem item : items) {
                        item.setCart(null);
                        shoppingitemRepo.save(item);
                        shoppingitemRepo.delete(item);
                    }
                    cartRepo.save(cart);
                }
            }
        }
        return order;
    }

}
