package org.attractor.edu_food.service;

import org.attractor.edu_food.dto.OrderItemDTO;

import java.util.List;

public interface OrderItemService {
    List<OrderItemDTO> findItemsByOrderId(Long orderId);
}
