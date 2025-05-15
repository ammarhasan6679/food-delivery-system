package com.food.delivery.service.interfaces;

import com.food.delivery.dto.MenuItemDTO;
import com.food.delivery.entity.MenuItem;

import java.util.List;

public interface MenuItemService {
    MenuItemDTO createMenuItem(MenuItemDTO menuItem);
    List<MenuItem> ItemByRestaurant(long restaurant_id);
    MenuItemDTO updateMenuItem(long id ,MenuItemDTO menuItem);
    void deleteMenuItem(long id);
    MenuItemDTO findMenuItemById(long id);
    List<MenuItem> searchItemByName(String keyword);
    List<MenuItemDTO>getAllMenuItems();
    List<MenuItemDTO>getItemsByPriceRange(double low, double high);
}
