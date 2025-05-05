package org.attractor.edu_food.config;

import lombok.RequiredArgsConstructor;
import org.attractor.edu_food.model.Cart;
import org.attractor.edu_food.model.CartItem;
import org.attractor.edu_food.service.CartService;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalControllerAdvice {

    private final CartService cartService;

    @ModelAttribute
    public void addCartAttributes(
            @CookieValue(value = "cart", required = false) String cartCookie,
            org.springframework.ui.Model model
    ) {
        Cart cart = cartService.getCartFromCookie(cartCookie);
        int totalItems = cart.getItems().stream()
                .mapToInt(CartItem::getQuantity)
                .sum();
        model.addAttribute("totalItems", totalItems);
    }
}