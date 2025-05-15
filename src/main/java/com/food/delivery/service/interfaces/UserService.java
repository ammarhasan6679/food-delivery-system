package com.food.delivery.service.interfaces;

import com.food.delivery.dto.UserDto;
import com.food.delivery.dto.UserLoginDTO;
import com.food.delivery.dto.UserRegisterDTO;
import com.food.delivery.entity.User;

import java.util.List;

public interface UserService {
    UserDto registerUser(UserRegisterDTO dto);
    String login(UserLoginDTO dto);
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
}
