package org.attractor.edu_food.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attractor.edu_food.dto.OrderItemDTO;
import org.attractor.edu_food.model.Order;
import org.attractor.edu_food.model.OrderItem;
import org.attractor.edu_food.repository.OrderItemRepository;
import org.attractor.edu_food.service.OrderItemService;
import org.attractor.edu_food.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository repository;
    private final OrderService orderService;

    @Override
    public List<OrderItemDTO> findItemsByOrderId(Long orderId) {
        log.info("Finding items by order id {}", orderId);
        Order order = orderService.getOrderById(orderId);
        List<OrderItem> items = repository.findOrderItemsByOrder(order);

        return items.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public OrderItemDTO convertToDto(OrderItem orderItem) {
        return new OrderItemDTO(
                orderItem.getDish().getName(),
                orderItem.getQuantity(),
                orderItem.getPrice(),
                orderItem.getDish().getRestaurant().getName()
        );
    }

}
