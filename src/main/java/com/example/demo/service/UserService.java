package com.example.demo.service;

import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserResponseDto;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public User listUniqueUser(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public UserResponseDto createUser(UserCreateDto dto){
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        user = userRepository.save(user);

        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public User editUser(Long id, User changes){
        User user = userRepository.getReferenceById(id);

        user.setName(changes.getName());
        user.setEmail(changes.getEmail());

        return userRepository.save(user);

    }

    public User deleteUser(Long id){
        User user = userRepository.findById(id).orElse(null);
        userRepository.delete(user);
        return user;
    }

}
