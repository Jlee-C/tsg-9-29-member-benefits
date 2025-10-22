package com.yorksolutions.backend.services;

import com.yorksolutions.backend.entities.User;
import com.yorksolutions.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserGenerator {

    private final UserRepository userRepository;

    private final String[] firstNames = {
            "Olivia", "Liam", "Emma", "Noah", "Ava",
            "Elijah", "Sophia", "James", "Isabella", "Benjamin",
            "Mia", "Lucas", "Charlotte", "Mason", "Amelia",
            "Ethan", "Harper", "Logan", "Evelyn", "Jacob"
    };

    private final String[] lastNames = {
            "Smith", "Johnson", "Williams", "Brown", "Jones",
            "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
            "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson",
            "Thomas", "Taylor", "Moore", "Jackson", "Martin"
    };


    public void generateRandomUser(int numberOfUsers){
        for(int i = 0; i < numberOfUsers; i++) {
            int fNum = ThreadLocalRandom.current().nextInt(0, firstNames.length);
            int lNum = ThreadLocalRandom.current().nextInt(0, lastNames.length);
            String firstName = firstNames[fNum];
            String lastName = lastNames[lNum];
            User user = new User(firstName, lastName);
            log.info("Generated {} user {}, expected: {} times", fNum, lastName, numberOfUsers);
            userRepository.save(user);
        }
    }
}
