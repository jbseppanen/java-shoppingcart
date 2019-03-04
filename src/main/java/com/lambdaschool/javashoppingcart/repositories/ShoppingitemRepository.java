package com.lambdaschool.javashoppingcart.repositories;

import com.lambdaschool.javashoppingcart.models.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingitemRepository extends JpaRepository<ShoppingItem, Long> {
}
