package com.yorksolutions.backend.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DataController {

    @GetMapping()
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("This is a test");
    }

    @GetMapping("/hello")
    public String HelloWorld(@RequestParam(value="name", defaultValue="You", required = false) String userName, @RequestParam(name="id") String emplId) {
        return String.format("Hello %1$s! You have the Id: %2$s", userName,  emplId);
    }
}
