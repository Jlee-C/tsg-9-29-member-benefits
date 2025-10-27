package com.yorksolutions.backend.controllers;

import com.yorksolutions.backend.entities.Member;
import com.yorksolutions.backend.repositories.UserRepository;
import com.yorksolutions.backend.services.DataSeeder;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BackendController {

    private DataSeeder dataSeeder;
    private UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody Member member) {
        if(userRepository.findByAuthSub(member.getUser().getAuthSub()).isEmpty()) {
            dataSeeder.generateData(member);
            return ResponseEntity.ok("User created successfully: " + member.getId());
        }
        else{
            return ResponseEntity.ok("User already exists: " + member.getUser().getAuthSub());
        }
    }

}
