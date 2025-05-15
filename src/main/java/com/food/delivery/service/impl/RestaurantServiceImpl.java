package com.food.delivery.service.impl;

import com.food.delivery.dto.RestaurantDTO;
import com.food.delivery.entity.Restaurant;
import com.food.delivery.repository.RestaurantRepository;
import com.food.delivery.service.interfaces.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
this.name = name;
        this.address = address;
        this.cuisine = cuisine;
        this.isOpen = isOpen;
        this.city = city;
        this.phone = phone;
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public RestaurantDTO createRestaurant(RestaurantDTO dto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setCity(dto.getCity());
        restaurant.setIsOpen(dto.getIsOpen());
        restaurant.setPhone(dto.getPhone());
        restaurant.setCuisine(dto.getCuisine());
        Restaurant saved = restaurantRepository.save(restaurant);

        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setAddress(restaurant.getAddress());
        restaurantDTO.setCity(restaurant.getCity());
        restaurantDTO.setPhone(restaurant.getPhone());
        restaurantDTO.setCuisine(restaurant.getCuisine());
        restaurantDTO.setName(restaurant.getName());
        restaurantDTO.setIsOpen(restaurant.getIsOpen());

        return restaurantDTO;
    }
    @Override
    public List<Restaurant>getAllRestaurants() {
        return restaurantRepository.findAll();
    }


    @Override
    public String getRestaurentById(long id){
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(restaurant.isEmpty()){
            throw new RuntimeException("Restaurant not found");
        }
        return restaurant.get().getName();
        //return restaurantRepository.findById(id).get().getName();
    }

    @Override
    public Restaurant updateRestaurant(long id, Restaurant updated){
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if(optionalRestaurant.isEmpty()){
            throw new RuntimeException("Restaurant not found");
        }
        Restaurant existingRestaurant = optionalRestaurant.get();
        existingRestaurant.setName(updated.getName());
        existingRestaurant.setAddress(updated.getAddress());
        existingRestaurant.setPhone(updated.getPhone());
        existingRestaurant.setCuisine(updated.getCuisine());
        existingRestaurant.setIsOpen(updated.getIsOpen());
        return restaurantRepository.save(existingRestaurant);
    }

    @Override
    public void deleteRestaurant(long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Restaurant not found"));
        restaurantRepository.delete(restaurant);
        /*
        MenuItem menuitem = foodItemRepository.findById(id)
                        .orElseThrow(()->new RuntimeException("Menu item not found"));
        foodItemRepository.delete(menuitem);
         */
//        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
//        if(optionalRestaurant.isEmpty()){
//            throw new RuntimeException("Restaurant not found");
//        }
//        restaurantRepository.delete(optionalRestaurant.get());
    }

    @Override
    public List<RestaurantDTO>getRestaurantByCity(String city) {
//        return restaurantRepository.findByCity(city);
        List<Restaurant> restaurant = restaurantRepository.findByCity(city);


        return restaurant.stream().map(menu-> {
            RestaurantDTO dto = new RestaurantDTO();
            dto.setName(menu.getName());
            dto.setAddress(menu.getAddress());
            dto.setIsOpen(menu.getIsOpen());
            return dto;
        }).collect(Collectors.toList());
    }

    private RestaurantDTO convertToDTO(Restaurant restaurant) {
        RestaurantDTO dto = new RestaurantDTO();
        dto.setName(restaurant.getName());
        dto.setAddress(restaurant.getAddress());
        dto.setCity(restaurant.getCity());
        dto.setCuisine(restaurant.getCuisine());
        dto.setPhone(restaurant.getPhone());
        dto.setIsOpen(restaurant.getIsOpen());
        return dto;
    }

    @Override
    public List<RestaurantDTO> findByCuisine(String cuisine) {
        List<Restaurant> restaurants = restaurantRepository.findByCuisine(cuisine);
        return restaurants.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<RestaurantDTO> findByIsOpen(boolean isOpen) {
        List<Restaurant> restaurants = restaurantRepository.findByIsOpen(isOpen);
        return restaurants.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

}
