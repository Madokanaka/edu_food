package org.attractor.edu_food.repository;

import org.attractor.edu_food.model.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
    Page<Restaurant> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Optional<Restaurant> findById(Long id);
}
