package com.food.delivery.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MenuItemDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private Boolean isAvailable;
    private Long restaurantId;

    public MenuItemDTO() {

    }
    public MenuItemDTO(Long id, String name, String description, Double price,String category,Boolean isAvailable, Long restaurantId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurantId = restaurantId;
        this.category = category;
        this.isAvailable = isAvailable;
    }
}
