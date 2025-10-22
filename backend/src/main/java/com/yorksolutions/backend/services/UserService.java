package com.yorksolutions.backend.services;

import com.yorksolutions.backend.entities.User;
import com.yorksolutions.backend.repositories.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }

    public User addUser(User user) {
            return userRepository.save(user);
    }

    public String deleteUser(UUID id) {
        try {
            String name = userRepository.findById(id).get().getFirstName();
            userRepository.deleteById(id);
            return "User "+ name + " deleted successfully!";
        }
        catch (EmptyResultDataAccessException | NoSuchElementException e) {
            return "User not found";
        }
    }

}
