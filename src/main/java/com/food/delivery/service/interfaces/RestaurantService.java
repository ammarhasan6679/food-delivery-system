package com.food.delivery.service.interfaces;

import com.food.delivery.dto.RestaurantDTO;
import com.food.delivery.entity.Restaurant;

import java.util.List;
//findByCuisine(String c)
public interface RestaurantService {
    RestaurantDTO createRestaurant(RestaurantDTO restaurant);
    List<Restaurant> getAllRestaurants();
    String getRestaurentById(long id);
    Restaurant updateRestaurant(long id, Restaurant updated);
    void deleteRestaurant(long id);
    List<RestaurantDTO>getRestaurantByCity(String city);
    List<RestaurantDTO>findByCuisine(String cuisine);
    List<RestaurantDTO>findByIsOpen(boolean isOpen);
}
