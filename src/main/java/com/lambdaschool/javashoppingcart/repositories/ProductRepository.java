package com.lambdaschool.javashoppingcart.repositories;

import com.lambdaschool.javashoppingcart.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
