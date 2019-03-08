package com.lambdaschool.javashoppingcart.repositories;

import com.lambdaschool.javashoppingcart.models.Orderitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderitemRepository extends JpaRepository<Orderitem, Long> {
}
