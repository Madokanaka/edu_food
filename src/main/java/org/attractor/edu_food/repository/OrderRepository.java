package org.attractor.edu_food.repository;

import org.attractor.edu_food.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.attractor.edu_food.model.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserOrderByCreatedAtDesc(User user);}
