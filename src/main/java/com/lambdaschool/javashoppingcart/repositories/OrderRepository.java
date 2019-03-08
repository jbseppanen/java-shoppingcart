package com.lambdaschool.javashoppingcart.repositories;

import com.lambdaschool.javashoppingcart.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
