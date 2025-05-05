package org.attractor.edu_food.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attractor.edu_food.dto.OrderDTO;
import org.attractor.edu_food.model.Order;
import org.attractor.edu_food.model.User;
import org.attractor.edu_food.service.OrderService;
import org.attractor.edu_food.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ProfileController {

    private final OrderService orderService;
    private final UserService userService;

    @GetMapping("/profile")
    public String showProfile(@AuthenticationPrincipal org.springframework.security.core.userdetails.User user, Model model) {
        if (user == null) {
            log.warn("User not authenticated, redirecting to login");
            return "redirect:/auth/login";
        }
        User userM = userService.findByEmail(user.getUsername());
        List<OrderDTO> orders = orderService.getUserOrders(userM);
        model.addAttribute("user", userM);
        model.addAttribute("orders", orders);
        return "profile/profile";
    }

//    @GetMapping("/orders/{id}")
//    public String showOrderDetails(@PathVariable Long id, @AuthenticationPrincipal User user, Model model) {
//        if (user == null) {
//            log.warn("User not authenticated, redirecting to login");
//            return "redirect:/auth/login";
//        }
//        Order order = orderService.getOrderById(id)
//                .filter(o -> o.getUser().getId().equals(user.getId()))
//                .orElseThrow(() -> new IllegalArgumentException("Order not found or access denied: " + id));
//        model.addAttribute("order", order);
//        return "order-details";
//    }
}