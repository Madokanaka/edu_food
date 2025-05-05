package org.attractor.edu_food.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.attractor.edu_food.dto.DishDTO;
import org.attractor.edu_food.model.Dish;
import org.attractor.edu_food.repository.DishRepository;
import org.attractor.edu_food.service.DishService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Override
    public Page<DishDTO> findDishesByRestaurantId(Long restaurantId, String page) {
        int pageNumber = parsePageParameter(page);
        Pageable pageable = PageRequest.of(pageNumber - 1, 10);
        log.info("Fetching dishes for restaurant id: {}, page: {}", restaurantId, pageNumber);
        Page<Dish> dishPage = dishRepository.findByRestaurantId(restaurantId, pageable);
        return dishPage.map(this::convertToDTO);
    }

    private DishDTO convertToDTO(Dish dish) {
        return new DishDTO(
                dish.getId(),
                dish.getName(),
                dish.getDescription(),
                dish.getPrice(),
                dish.getRestaurant().getId()
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