package org.attractor.edu_food.service;

import org.attractor.edu_food.dto.RestaurantDTO;
import org.springframework.data.domain.Page;

public interface RestaurantService {
    Page<RestaurantDTO> findRestaurants(String page, String search);

    RestaurantDTO findById(Long id);
}
