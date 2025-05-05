package org.attractor.edu_food.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attractor.edu_food.dto.DishDTO;
import org.attractor.edu_food.dto.RestaurantDTO;
import org.attractor.edu_food.model.Cart;
import org.attractor.edu_food.model.CartItem;
import org.attractor.edu_food.service.CartService;
import org.attractor.edu_food.service.DishService;
import org.attractor.edu_food.service.RestaurantService;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Base64;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

    private final DishService dishService;
    private final RestaurantService restaurantService;
    private final ObjectMapper objectMapper;

    @Override
    public Cart getCartFromCookie(String cartCookie) {
        if (cartCookie == null || cartCookie.isEmpty()) {
            log.debug("Cart cookie is empty or null, returning new Cart");
            return new Cart();
        }
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(cartCookie);
            String json = new String(decodedBytes);
            log.debug("Deserializing cart from JSON: {}", json);
            Cart cart = objectMapper.readValue(json, Cart.class);
            log.debug("Successfully deserialized cart: {}", cart);
            for (CartItem item : cart.getItems()) {
                if (item.getRestaurantName() == null) {
                    log.warn("CartItem with dishId {} has null restaurantName, setting default", item.getDishId());
                    item.setRestaurantName("Unknown Restaurant");
                }
            }
            return cart;
        } catch (Exception e) {
            log.error("Failed to deserialize cart from cookie '{}': {}", cartCookie, e.getMessage(), e);
            return new Cart();
        }
    }

    @Override
    public void addToCart(Long dishId, int quantity, Cart cart, HttpServletResponse response) {
        if (quantity <= 0) {
            log.warn("Invalid quantity {} for dishId {}", quantity, dishId);
            return;
        }
        DishDTO dish;
        RestaurantDTO restaurant;
        try {
            dish = dishService.findById(dishId);
            if (dish == null) {
                log.error("Dish with id {} not found", dishId);
                return;
            }
            restaurant = restaurantService.findById(dish.getRestaurantId());
            if (restaurant == null) {
                log.error("Restaurant with id {} not found for dishId {}", dish.getRestaurantId(), dishId);
                return;
            }
        } catch (Exception e) {
            log.error("Failed to add dishId {} to cart: {}", dishId, e.getMessage());
            return;
        }
        CartItem item = new CartItem(
                dish.getId(),
                dish.getName(),
                dish.getDescription(),
                dish.getPrice(),
                quantity,
                restaurant.getName()
        );
        cart.addItem(item);
        log.info("Added dish {} from restaurant {} (quantity: {}) to cart", dish.getName(), restaurant.getName(), quantity);
        saveCartToCookie(cart, response);
    }

    @Override
    public void removeFromCart(Long dishId, Cart cart, HttpServletResponse response) {
        cart.removeItem(dishId);
        log.info("Removed dishId {} from cart", dishId);
        saveCartToCookie(cart, response);
    }

    @Override
    public void updateQuantity(Long dishId, int quantity, Cart cart, HttpServletResponse response) {
        if (quantity < 0) {
            log.warn("Invalid quantity {} for dishId {}", quantity, dishId);
            return;
        }
        cart.updateQuantity(dishId, quantity);
        log.info("Updated quantity for dishId {} to {}", dishId, quantity);
        saveCartToCookie(cart, response);
    }

    @Override
    public void saveCartToCookie(Cart cart, HttpServletResponse response) {
        try {
            String json = objectMapper.writeValueAsString(cart);
            String encoded = Base64.getEncoder().encodeToString(json.getBytes());
            Cookie cookie = new Cookie("cart", encoded);
            cookie.setPath("/");
            cookie.setMaxAge(7 * 24 * 60 * 60);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            log.debug("Saved cart to cookie: {}", encoded);
        } catch (JsonProcessingException e) {
            log.error("Failed to serialize cart to cookie: {}", e.getMessage());
        }
    }

    @Override
    public int getTotalItems(Cart cart) {
        int total = cart.getTotalItems();
        log.debug("Total items in cart: {}", total);
        return total;
    }

    @Override
    public double getTotalPrice(Cart cart) {
        double total = cart.getTotalPrice();
        log.debug("Total price of cart: {}", total);
        return total;
    }
}