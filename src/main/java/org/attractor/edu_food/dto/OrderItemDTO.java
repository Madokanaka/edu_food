package org.attractor.edu_food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {
    private String dishName;
    private int quantity;
    private BigDecimal price;
    private String restaurantName;
}
