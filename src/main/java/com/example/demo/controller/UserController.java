package com.example.demo.controller;

import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.entity.user.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> listAllUsers(){
        return new ResponseEntity<>(userService.listUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> listser(@PathVariable Long id){
        return new ResponseEntity<>(userService.listUniqueUser(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid UserCreateDto dto){
        try {
            return new ResponseEntity<>(userService.createUser(dto),HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    //Não foi apagado pois mais testes serão feitos ainda.
    /*@GetMapping("/whoami")
    public Map<String, Object> whoami(Authentication authentication) {

        Map<String, Object> data = new HashMap<>();
        data.put("username", authentication.getName());
        data.put("roles", authentication.getAuthorities());

        return data;
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody User changes){
        return new ResponseEntity<>(userService.editUser(id, changes),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}/promote")
    public void promoteToAdmin(@PathVariable Long id){
        userService.promoteToAdmin(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }

}
