package com.food.delivery.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;
    private String phone;
    private String role;
    private Long id;

    public UserDto(){

    }
    public UserDto(String name, String email, String phone, String role, Long id) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.id = id;
    }



}
