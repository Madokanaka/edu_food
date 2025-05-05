package org.attractor.edu_food.controller;

import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.attractor.edu_food.dto.DishDTO;
import org.attractor.edu_food.model.Cart;
import org.attractor.edu_food.model.Order;
import org.attractor.edu_food.service.CartService;
import org.attractor.edu_food.service.DishService;
import org.attractor.edu_food.service.OrderService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final DishService dishService;
    private final OrderService orderService;

    @PostMapping("/add")
    public String addToCart(
            @RequestParam Long dishId,
            @RequestParam int quantity,
            @CookieValue(value = "cart", required = false) String cartCookie,
            HttpServletResponse response,
            RedirectAttributes redirectAttributes
    ) {
        Cart cart = cartService.getCartFromCookie(cartCookie);
        cartService.addToCart(dishId, quantity, cart, response);
        DishDTO dish = dishService.findById(dishId);
        if (quantity < 1) {
            redirectAttributes.addFlashAttribute("error", "Количество не может быть отрицательным");
            return "redirect:/restaurants/" + dish.getRestaurantId();
        }
        redirectAttributes.addFlashAttribute("success", "Блюдо " + dish.getName() + " было добавлено в тележку");
        return "redirect:/restaurants/" + dish.getRestaurantId();
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

    @PostMapping("/makeOrder")
    public String makeOrder(
            @CookieValue(value = "cart", required = false) String cartCookie,
            @AuthenticationPrincipal User user,
            HttpServletResponse response,
            RedirectAttributes redirectAttributes
    ) {
        Cart cart = cartService.getCartFromCookie(cartCookie);
        if (cart.getItems().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Нельзя создать заказ, корзина пуста");
            return "redirect:/cart";
        }
        try {
            Long order = orderService.createOrderFromCart(cart, user);
            Cookie cookie = new Cookie("cart", "");
            cookie.setPath("/");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            redirectAttributes.addFlashAttribute("success", "Заказ создан успешно. ID заказа: " + order);
            return "redirect:/profile";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Создание заказа неуспешно: " + e.getMessage());
            return "redirect:/cart";
        }
    }
}