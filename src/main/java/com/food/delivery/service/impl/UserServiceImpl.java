package com.food.delivery.service.impl;

import com.food.delivery.dto.UserDto;
import com.food.delivery.dto.UserLoginDTO;
import com.food.delivery.dto.UserRegisterDTO;
import com.food.delivery.entity.User;
import com.food.delivery.repository.UserRepository;
import com.food.delivery.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto registerUser(UserRegisterDTO dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setRole(User.Role.valueOf("CUSTOMER"));
        user.setPhone(dto.getPhone());
        User saved = userRepository.save(user);
        return mapToDTO(saved);
    }

    @Override
    public String login(UserLoginDTO dto){
        Optional<User> userOptional = userRepository.findByEmail(dto.getEmail());

        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(user.getPassword().equals(dto.getPassword())){
                return "LOGIN_SUCCESS";
            }else{
                throw new RuntimeException("Invalid password");
            }
        }else{
            throw  new RuntimeException("User not found");
        }
    }
  //  @Override
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
    @Override
    public List<UserDto> getAllUsers(){
        return userRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        return mapToDTO(user);

    }

    private UserDto mapToDTO(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(String.valueOf(user.getRole()));
        dto.setPhone(user.getPhone());
        return dto;
    }
}

