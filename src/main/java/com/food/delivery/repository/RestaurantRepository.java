package com.food.delivery.repository;

import com.food.delivery.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCity(String city);

    List<Restaurant> findByCuisine(String cuisine);

    List<Restaurant> findByIsOpen(Boolean isOpen);
}
