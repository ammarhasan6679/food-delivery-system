package com.food.delivery.service.impl;

import com.food.delivery.dto.MenuItemDTO;
import com.food.delivery.entity.MenuItem;
import com.food.delivery.entity.Restaurant;
import com.food.delivery.repository.FoodItemRepository;
import com.food.delivery.repository.RestaurantRepository;
import com.food.delivery.service.interfaces.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuItemServiceImpl implements MenuItemService {
    @Autowired
    private FoodItemRepository foodItemRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public MenuItemDTO createMenuItem(MenuItemDTO dto) {
        Restaurant restaurant = restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(()->new RuntimeException("Restaurant not found with ID: " + dto.getRestaurantId()));

        MenuItem menuItem = new MenuItem();
        menuItem.setRestaurant(restaurant);
        menuItem.setName(dto.getName());
        menuItem.setDescription(dto.getDescription());
        menuItem.setPrice(dto.getPrice());
        menuItem.setCategory(dto.getCategory());
        menuItem.setIsAvailable(dto.getIsAvailable());

        MenuItem saved = foodItemRepository.save(menuItem);

        MenuItemDTO savedDto = new MenuItemDTO();
        savedDto.setId(saved.getId());
        savedDto.setName(menuItem.getName());
        savedDto.setDescription(menuItem.getDescription());
        savedDto.setPrice(menuItem.getPrice());
        savedDto.setCategory(menuItem.getCategory());
        savedDto.setIsAvailable(menuItem.getIsAvailable());
        savedDto.setRestaurantId(saved.getRestaurant().getId());

        return savedDto;
//        Long restaurantId = menuItem.getRestaurant().getId();
//        if (!restaurantRepository.existsById(restaurantId)) {
//            throw new RuntimeException("Restaurant does not exist");
//        }
//        return foodItemRepository.save(menuItem);
    }

    @Override
    public List<MenuItem> ItemByRestaurant(long restaurant_id) {
        if (!restaurantRepository.existsById(restaurant_id)) {
            throw new RuntimeException("Restaurant not found");
        }
        return foodItemRepository.findByRestaurantId(restaurant_id);
        //return List.of();
    }

    @Override
    public MenuItemDTO updateMenuItem(long id, MenuItemDTO updatedMenuItem) {

        MenuItem existingItem = foodItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));

        existingItem.setName(updatedMenuItem.getName());
        existingItem.setPrice(updatedMenuItem.getPrice());
        existingItem.setDescription(updatedMenuItem.getDescription());

        if (updatedMenuItem.getRestaurantId() != null) {
            Restaurant restaurant = restaurantRepository.findById(updatedMenuItem.getRestaurantId())
                    .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + updatedMenuItem.getRestaurantId()));
            existingItem.setRestaurant(restaurant);
        }

        MenuItem updated = foodItemRepository.save(existingItem);

        MenuItemDTO updatedDTO = new MenuItemDTO();
        updatedDTO.setId(updated.getId());
        updatedDTO.setName(updated.getName());
        updatedDTO.setPrice(updated.getPrice());
        updatedDTO.setDescription(updated.getDescription());
        updatedDTO.setRestaurantId(updated.getRestaurant().getId());

        return updatedDTO;

//        existingItem.setName(updatedMenuItem.getName());
//        existingItem.setDescription(updatedMenuItem.getDescription());
//        existingItem.setPrice(updatedMenuItem.getPrice());
//
//        return foodItemRepository.save(existingItem);
//        Optional<MenuItem> item = foodItemRepository.findById(id);
//        if (item.isEmpty()) {
//            throw new RuntimeException("No such item exists");
//        }
//
//        menuItem.setName(menuItem.getName());
//        menuItem.setDescription(menuItem.getDescription());
//        menuItem.setPrice(menuItem.getPrice());
//
//        return foodItemRepository.save(menuItem);
    }

    @Override
    public void deleteMenuItem(long id) {
//        if (!foodItemRepository.existsById(id)) {
//            throw new RuntimeException("Menu item not found");
//        }
        MenuItem menuitem = foodItemRepository.findById(id)
                        .orElseThrow(()->new RuntimeException("Menu item not found"));
        foodItemRepository.delete(menuitem);
    }

    @Override
    public MenuItemDTO findMenuItemById(long id) {
        MenuItem menuitem =  foodItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
        MenuItemDTO dto1 = new MenuItemDTO();
        dto1.setId(menuitem.getId());
        dto1.setName(menuitem.getName());
        dto1.setDescription(menuitem.getDescription());
        dto1.setPrice(menuitem.getPrice());
        dto1.setCategory(menuitem.getCategory());
        dto1.setIsAvailable(menuitem.getIsAvailable());
        dto1.setRestaurantId(menuitem.getRestaurant().getId());
        return dto1;
        //foodItemRepository.findbYiD(id).orElseThrow(()->new RuntimeException("Menu item not found"));
    }

    @Override
    public List<MenuItem> searchItemByName(String keyword) {
        return foodItemRepository.findByNameContainingIgnoreCase(keyword);
    }

    @Override
    public List<MenuItemDTO> getAllMenuItems() {
        List<MenuItem> menuItems = foodItemRepository.findAll();
        return menuItems.stream().map(menu->{
            MenuItemDTO dto = new MenuItemDTO();
            dto.setId(menu.getId());
            dto.setName(menu.getName());
            dto.setPrice(menu.getPrice());
            dto.setDescription(menu.getDescription());
            dto.setRestaurantId(menu.getRestaurant().getId());
            return dto;

        }).collect(Collectors.toList());

    }

    @Override
    public List<MenuItemDTO> getItemsByPriceRange(double low, double high) {
        List<MenuItem> menuItems = foodItemRepository.findByPriceBetween(low, high);
        return menuItems.stream().map(menu->{
            MenuItemDTO dto = new MenuItemDTO();
            //dto.setId(menu.getId());
            dto.setName(menu.getName());
            dto.setPrice(menu.getPrice());
            dto.setDescription(menu.getDescription());
            dto.setCategory(menu.getCategory());
            dto.setIsAvailable(menu.getIsAvailable());
            return dto;
        }).collect(Collectors.toList());
        //return foodItemRepository.findByPriceBetween(low,high);
    }



//    public void deleteMenuItem(long id) {
//        Optional<MenuItem> item = foodItemRepository.findById(id);
//        if (item.isEmpty()) {
//            throw new RuntimeException("No such item exists");
//        }
//        foodItemRepository.deleteById(id);
//    }



}
