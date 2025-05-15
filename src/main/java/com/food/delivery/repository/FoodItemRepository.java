package com.food.delivery.repository;

import com.food.delivery.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodItemRepository extends JpaRepository<MenuItem,Long> {
    List<MenuItem> findByRestaurantId(Long restaurantId);
    //List<MenuItem> findByCategory(String category);

    List<MenuItem> findByNameContainingIgnoreCase(String keyword);

    List<MenuItem> findByPriceBetween(double low, double high);
}
