package com.lambdaschool.javashoppingcart.controllers;

import com.lambdaschool.javashoppingcart.models.*;
import com.lambdaschool.javashoppingcart.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public Cart getShopperCart(@PathVariable long shopperid) {
        Optional<Shopper> foundShopper = shopperRepo.findById(shopperid);
        if (foundShopper.isPresent()) {
            Cart cart = foundShopper.get().getCart();
            if (cart == null) {
                cart = new Cart();
                cart.setShopper(foundShopper.get());
                cartRepo.save(cart);
            }
            return cart;
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
            Cart cart = foundShopper.get().getCart();
            if (cart != null) {
                if (cart.getItems()!=null) {
                    order = cart.getAsOrder();
                }
            }
        }
        order.setShippedstatus(1);
        return orderRepo.save(order);
    }

}
