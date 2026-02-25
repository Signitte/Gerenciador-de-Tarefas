package com.example.demo.service;

import com.example.demo.entity.user.Role;
import com.example.demo.entity.user.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    void shouldPromoteToAdmin() {
        User user = new User();
        user.setName("Teste");
        user.setEmail("teste@email.com");
        user.setPassword("123");
        user.setRole(Role.ROLE_USER);

        user = userRepository.save(user);

        Long id = user.getId();

        userService.promoteToAdmin(id);

        User updated = userRepository.findById(id).orElseThrow();

        assertEquals(Role.ROLE_ADMIN, updated.getRole());
    }
}