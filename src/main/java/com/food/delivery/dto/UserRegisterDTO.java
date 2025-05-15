package com.food.delivery.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO {
    private String name;
    private String email;
    private String password;
    private String phone;

    public UserRegisterDTO() {

    }
    public UserRegisterDTO(String name, String email, String password,String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
}
