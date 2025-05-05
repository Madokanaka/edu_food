package org.attractor.edu_food.controller;

import lombok.RequiredArgsConstructor;
import org.attractor.edu_food.model.Cart;
import org.attractor.edu_food.service.CartService;
import org.attractor.edu_food.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final DishService dishService;

    @PostMapping("/add")
    public String addToCart(
            @RequestParam Long dishId,
            @RequestParam int quantity,
            @CookieValue(value = "cart", required = false) String cartCookie,
            HttpServletResponse response
    ) {
        Cart cart = cartService.getCartFromCookie(cartCookie);
        cartService.addToCart(dishId, quantity, cart, response);
        Long restaurantId = dishService.findById(dishId).getRestaurantId();
        return "redirect:/restaurants/" + restaurantId;
    }

    @GetMapping
    public String showCart(
            @CookieValue(value = "cart", required = false) String cartCookie,
            Model model
    ) {
        Cart cart = cartService.getCartFromCookie(cartCookie);
        model.addAttribute("cart", cart);
        model.addAttribute("totalItems", cartService.getTotalItems(cart));
        model.addAttribute("totalPrice", cartService.getTotalPrice(cart));
        return "cart/cart";
    }

    @PostMapping("/remove")
    public String removeFromCart(
            @RequestParam Long dishId,
            @CookieValue(value = "cart", required = false) String cartCookie,
            HttpServletResponse response
    ) {
        Cart cart = cartService.getCartFromCookie(cartCookie);
        cartService.removeFromCart(dishId, cart, response);
        return "redirect:/cart";
    }

    @PostMapping("/update")
    public String updateQuantity(
            @RequestParam Long dishId,
            @RequestParam int quantity,
            @CookieValue(value = "cart", required = false) String cartCookie,
            HttpServletResponse response
    ) {
        Cart cart = cartService.getCartFromCookie(cartCookie);
        cartService.updateQuantity(dishId, quantity, cart, response);
        return "redirect:/cart";
    }
}