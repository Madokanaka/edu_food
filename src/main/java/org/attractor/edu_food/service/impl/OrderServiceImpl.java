package org.attractor.edu_food.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attractor.edu_food.dto.OrderDTO;
import org.attractor.edu_food.dto.OrderItemDTO;
import org.attractor.edu_food.exceptions.ResourceNotFoundException;
import org.attractor.edu_food.model.Cart;
import org.attractor.edu_food.model.CartItem;
import org.attractor.edu_food.model.Dish;
import org.attractor.edu_food.model.Order;
import org.attractor.edu_food.model.OrderItem;
import org.attractor.edu_food.model.User;
import org.attractor.edu_food.repository.DishRepository;
import org.attractor.edu_food.repository.OrderRepository;
import org.attractor.edu_food.service.OrderService;
import org.attractor.edu_food.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final DishRepository dishRepository;
    private final UserService userService;

    @Override
    @Transactional
    public Order createOrderFromCart(Cart cart, org.springframework.security.core.userdetails.User userAuth) {
        if (cart.getItems().isEmpty()) {
            log.warn("Cannot create order: cart is empty");
        }

        User user = userService.findByEmail(userAuth.getUsername());
        Order order = new Order();
        order.setUser(user);
        order.setCreatedAt(java.time.LocalDateTime.now());
        order.setTotalPrice(BigDecimal.valueOf(cart.getTotalPrice()));

        for (CartItem cartItem : cart.getItems()) {
            Dish dish = dishRepository.findById(cartItem.getDishId())
                    .orElseThrow(() -> new IllegalStateException("Dish not found: " + cartItem.getDishId()));
            OrderItem orderItem = new OrderItem();
            orderItem.setDish(dish);
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getPrice());
            orderItem.setOrder(order);
            order.getItems().add(orderItem);
        }

        Order savedOrder = orderRepository.save(order);
        log.info("Created order {} for user {}", savedOrder.getId(), user.getEmail());
        return savedOrder;
    }

    @Override
    public List<OrderDTO> getUserOrders(User user) {
        List<Order> orders = orderRepository.findByUserOrderByCreatedAtDesc(user);
        return orders.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found: " + orderId));
    }

    private OrderDTO convertToDTO(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getCreatedAt(),
                order.getTotalPrice()
        );
    }
}