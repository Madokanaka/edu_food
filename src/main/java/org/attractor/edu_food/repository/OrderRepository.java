package org.attractor.edu_food.repository;

import org.attractor.edu_food.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
