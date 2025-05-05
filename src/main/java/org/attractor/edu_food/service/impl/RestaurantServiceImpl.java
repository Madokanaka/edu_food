package org.attractor.edu_food.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attractor.edu_food.dto.RestaurantDTO;
import org.attractor.edu_food.exceptions.ResourceNotFoundException;
import org.attractor.edu_food.model.Restaurant;
import org.attractor.edu_food.repository.RestaurantRepository;
import org.attractor.edu_food.service.RestaurantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Page<RestaurantDTO> findRestaurants(String page, String search) {
        int pageNumber = parsePageParameter(page);

        Pageable pageable = PageRequest.of(pageNumber - 1, 4);

        Page<Restaurant> restaurantPage;

        if (search != null && !search.isEmpty()) {
            restaurantPage = restaurantRepository.findByNameContainingIgnoreCase(search, pageable);
        } else {
            restaurantPage = restaurantRepository.findAll(pageable);
        }

        if (restaurantPage.getTotalPages() > 0 && pageNumber >= restaurantPage.getTotalPages()) {
            pageable = PageRequest.of(restaurantPage.getTotalPages() - 1, 4);

            if (search != null && !search.isEmpty()) {
                restaurantPage = restaurantRepository.findByNameContainingIgnoreCase(search, pageable);
            } else {
                restaurantPage = restaurantRepository.findAll(pageable);
            }
        }

        return restaurantPage.map(this::convertToDTO);
    }

    @Override
    public RestaurantDTO findById(Long id) {
        log.info("Fetching restaurant with id: {}", id);
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant " + id + " Not Found"));
        return convertToDTO(restaurant);
    }

    private RestaurantDTO convertToDTO(Restaurant restaurant) {
        return new RestaurantDTO(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getDescription(),
                restaurant.getPhotoName()
        );
    }

    private int parsePageParameter(String page) {
        try {
            int pageNumber = Integer.parseInt(page);
            if (pageNumber < 1) {
                log.warn("Page index less than 1, setting to 1");
                return 1;
            }
            return pageNumber;
        } catch (NumberFormatException e) {
            log.warn("Invalid page parameter: {}. Setting to default 1", page);
            return 1;
        }
    }

}
