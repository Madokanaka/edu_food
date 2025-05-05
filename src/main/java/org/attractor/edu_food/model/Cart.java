package org.attractor.edu_food.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        for (CartItem existingItem : items) {
            if (existingItem.getDishId().equals(item.getDishId())) {
                existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(Long dishId) {
        items.removeIf(item -> item.getDishId().equals(dishId));
    }


    public void updateQuantity(Long dishId, int quantity) {
        for (CartItem item : items) {
            if (item.getDishId().equals(dishId)) {
                if (quantity <= 0) {
                    items.remove(item);
                } else {
                    item.setQuantity(quantity);
                }
                return;
            }
        }
    }

    public int getTotalItems() {
        return items.stream().mapToInt(CartItem::getQuantity).sum();
    }


    public double getTotalPrice() {
        return items.stream()
                .mapToDouble(item -> item.getPrice().doubleValue() * item.getQuantity())
                .sum();
    }
}