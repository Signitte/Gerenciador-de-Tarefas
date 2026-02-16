package com.example.demo.service;

import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserResponseDto;
import com.example.demo.entity.user.Role;
import com.example.demo.entity.user.User;
import com.example.demo.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.ROLE_USER);
        user = userRepository.save(user);

        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    @PostConstruct
    public void createAdmin(){

        if(userRepository.findByEmail("admin@gmail.com").isEmpty()){

            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("123456789"));
            admin.setRole(Role.ROLE_ADMIN);
            userRepository.save(admin);
        }
    }

    public void promoteToAdmin(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setRole(Role.ROLE_ADMIN);
        userRepository.save(user);
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
