package com.food.delivery.Controller;

import com.food.delivery.dto.MenuItemDTO;
import com.food.delivery.entity.MenuItem;
import com.food.delivery.service.interfaces.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuItemController {
    @Autowired
    private MenuItemService menuItemService;

    @PostMapping
    public ResponseEntity<MenuItemDTO> createMenuItem(@RequestBody MenuItemDTO dto) {
//createMenuItem
        MenuItemDTO menuitemdto = menuItemService.createMenuItem(dto);
        return new ResponseEntity<>(menuitemdto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MenuItemDTO> updateMenuItem(@PathVariable Long id, @RequestBody MenuItemDTO menuItemDTO) {
        MenuItemDTO updatedMenu = menuItemService.updateMenuItem(id,menuItemDTO);
        return new ResponseEntity<>(updatedMenu, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuItemDTO> getMenuItem(@PathVariable Long id) {
        MenuItemDTO menuDto = menuItemService.findMenuItemById(id);
        return new ResponseEntity<>(menuDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MenuItemDTO>> getMenuItems() {
        List<MenuItemDTO> items = menuItemService.getAllMenuItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/pricerange/{low}/{high}")
    public ResponseEntity<List<MenuItemDTO>> itemPriceRange(@PathVariable double low,
                                                            @PathVariable double high) {
        List<MenuItemDTO> items = menuItemService.getItemsByPriceRange(low,high);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

//    public List<MenuItem> getItemsByPriceRange(double low, double high) {
//        return foodItemRepository.findByPriceBetween(low,high);
//    }


}
