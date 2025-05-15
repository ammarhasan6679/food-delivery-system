package com.food.delivery.Controller;

import com.food.delivery.dto.RestaurantDTO;
import com.food.delivery.entity.Restaurant;
import com.food.delivery.service.interfaces.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<RestaurantDTO> createRestaurant(@RequestBody RestaurantDTO dto) {
        RestaurantDTO restaurantdto = restaurantService.createRestaurant(dto);
        return new ResponseEntity<>(restaurantdto, HttpStatus.CREATED);
    }

    //public void deleteRestaurant(long id)

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>("Restaurant Succesfully Deleted",HttpStatus.OK);
    }

    //public List<Restaurant>getRestaurantByCity(String city)
    @GetMapping("/{city}")
    public ResponseEntity<List<RestaurantDTO>> findRestaurantsByCity(@PathVariable String city) {
        List<RestaurantDTO> restaurantdto = restaurantService.getRestaurantByCity(city);
        return new ResponseEntity<>(restaurantdto,HttpStatus.OK);
    }
    @GetMapping("/cuisine/{cuisine}")
    public ResponseEntity<List<RestaurantDTO>> getByCuisine(@PathVariable String cuisine) {
        List<RestaurantDTO> list = restaurantService.findByCuisine(cuisine);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/isopen/{status}")
    public ResponseEntity<List<RestaurantDTO>> getByIsOpen(@PathVariable boolean status) {
        List<RestaurantDTO> list = restaurantService.findByIsOpen(status);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
