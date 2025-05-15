package com.food.delivery.Controller;

import com.food.delivery.dto.UserDto;
import com.food.delivery.dto.UserLoginDTO;
import com.food.delivery.dto.UserRegisterDTO;
import com.food.delivery.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserRegisterDTO userRegisterDTO){
        UserDto userDto = userService.registerUser(userRegisterDTO);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @PostMapping("/logic")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO userLoginDTO){
        String token = userService.login(userLoginDTO);
        return new ResponseEntity<>(token,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto userDto = userService.getUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtos = userService.getAllUsers();
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }
}
