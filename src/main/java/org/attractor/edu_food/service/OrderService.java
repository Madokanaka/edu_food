package org.attractor.edu_food.service;

import org.attractor.edu_food.dto.OrderDTO;
import org.attractor.edu_food.model.Cart;
import org.attractor.edu_food.model.Order;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface OrderService {
    Long createOrderFromCart(Cart cart, User user);

    List<OrderDTO> getUserOrders(org.attractor.edu_food.model.User user);

    Order getOrderById(Long orderId);

    OrderDTO getOrderDtoById(Long orderId, User user);

}