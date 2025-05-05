package org.attractor.edu_food.service;

import jakarta.servlet.http.HttpServletResponse;
import org.attractor.edu_food.model.Cart;

public interface CartService {
    Cart getCartFromCookie(String cartCookie);

    void addToCart(Long dishId, int quantity, Cart cart, HttpServletResponse response);

    void removeFromCart(Long dishId, Cart cart, HttpServletResponse response);

    void updateQuantity(Long dishId, int quantity, Cart cart, HttpServletResponse response);

    void saveCartToCookie(Cart cart, HttpServletResponse response);

    int getTotalItems(Cart cart);

    double getTotalPrice(Cart cart);
}
