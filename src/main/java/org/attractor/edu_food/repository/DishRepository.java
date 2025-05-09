package org.attractor.edu_food.repository;

import org.attractor.edu_food.model.Dish;
import org.attractor.edu_food.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    Page<Dish> findByRestaurantId(Long restaurantId, Pageable pageable);
}
