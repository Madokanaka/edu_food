package org.attractor.edu_food.controller;

import lombok.RequiredArgsConstructor;
import org.attractor.edu_food.dto.DishDTO;
import org.attractor.edu_food.dto.RestaurantDTO;
import org.attractor.edu_food.service.DishService;
import org.attractor.edu_food.service.RestaurantService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final DishService dishService;

    @GetMapping
    public String listRestaurants(
        @RequestParam(defaultValue = "1") String page,
        @RequestParam(required = false) String search,
        Model model
    ) {
        Page<RestaurantDTO> restaurants = restaurantService.findRestaurants(page, search);
        model.addAttribute("restaurants", restaurants.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", restaurants.getTotalPages());
        model.addAttribute("search", search);
        return "restaurants/restaurants";
    }

    @GetMapping("/{id}")
    public String showRestaurant(
            @PathVariable Long id,
            @RequestParam(defaultValue = "1") String page,
            Model model
    ) {
        RestaurantDTO restaurant = restaurantService.findById(id);
        Page<DishDTO> dishes = dishService.findDishesByRestaurantId(id, page);
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("dishes", dishes.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", dishes.getTotalPages());
        return "restaurants/restaurant";
    }
}
