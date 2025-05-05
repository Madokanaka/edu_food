package org.attractor.edu_food.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private Long dishId;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private String restaurantName;
}