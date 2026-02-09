package com.example.demo.service;

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

    public User createUser(User user){
        return userRepository.save(user);
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
