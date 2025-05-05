package org.attractor.edu_food.service;

import org.attractor.edu_food.dto.DishDTO;
import org.springframework.data.domain.Page;

public interface DishService {
    Page<DishDTO> findDishesByRestaurantId(Long restaurantId, String page);
}
