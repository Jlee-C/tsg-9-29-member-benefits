package com.yorksolutions.backend.controller;

import com.yorksolutions.backend.entities.User;
import com.yorksolutions.backend.repositories.UserRepository;
import com.yorksolutions.backend.services.GenerateRandomUser;
import com.yorksolutions.backend.services.UserGenerator;
import com.yorksolutions.backend.services.UserService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    
    private UserService userService;

    private UserGenerator userGenerator;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/find/all")
    public ResponseEntity<String> getAllUsers() {
        return ResponseEntity.ok(userService.findAll().toString());
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<String> getUserByFirstName(@PathVariable String name) {
        return ResponseEntity.ok(userService.findByFirstName(name).toString());

    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.findById(id).toString());

    }

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.addUser(user).toString());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @GetMapping("/generate-users/{numOfUsers}")
    public ResponseEntity<String> generateUsers(@PathVariable int numOfUsers) {
        userGenerator.generateRandomUser(numOfUsers);
        return ResponseEntity.ok("Generated " + numOfUsers + " users");
    }
    
}
