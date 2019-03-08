package com.lambdaschool.javashoppingcart.repositories;

import com.lambdaschool.javashoppingcart.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
