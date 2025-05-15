package com.food.delivery.dto;

import lombok.Getter;
import lombok.Setter;

/*
 private String name;

    private String address;

    private String phone;

    private String cuisine;

    private Boolean isOpen;

    private String city;
 */
@Getter
@Setter
public class RestaurantDTO {
    private String name;
    private String address;
    private String cuisine;
    private Boolean isOpen;;
    private String city;
    private String phone;

    public RestaurantDTO() {

    }
    public RestaurantDTO(String name, String address, String cuisine, Boolean isOpen, String city, String phone) {
        this.name = name;
        this.address = address;
        this.cuisine = cuisine;
        this.isOpen = isOpen;
        this.city = city;
        this.phone = phone;
    }


}
