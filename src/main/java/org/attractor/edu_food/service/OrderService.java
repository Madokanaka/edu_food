package org.attractor.edu_food.service;

import org.attractor.edu_food.model.Cart;
import org.attractor.edu_food.model.Order;
import org.springframework.security.core.userdetails.User;

public interface OrderService {
    Order createOrderFromCart(Cart cart, User user);
}