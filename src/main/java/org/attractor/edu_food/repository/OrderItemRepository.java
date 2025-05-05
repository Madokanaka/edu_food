package org.attractor.edu_food.repository;

import org.attractor.edu_food.model.Order;
import org.attractor.edu_food.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findOrderItemsByOrder(Order order);
}
