package com.yorksolutions.backend.controller;

import com.yorksolutions.backend.entities.User;
import com.yorksolutions.backend.services.UserGenerator;
import com.yorksolutions.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/public/users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;

    private final UserGenerator userGenerator;

    @GetMapping("")
    public String testPage(){
        return "<h1>Something!</h1>";

    }

    @GetMapping("/find/all")
    public ResponseEntity<List <User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/find/all/count")
    public ResponseEntity<Integer> userCount() {
        return  ResponseEntity.ok(userService.findAll().size());
    }

    @GetMapping("/find/by-name/{name}")
    public ResponseEntity<String> getUserByFirstName(@PathVariable String name) {
        return ResponseEntity.ok(userService.findByFirstName(name).toString());

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.findById(id).get());

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
        log.info("Generated {} users", numOfUsers);
        return ResponseEntity.ok("Generated " + numOfUsers + " users");
    }
    
}
