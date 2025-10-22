package com.yorksolutions.backend.services;

import com.yorksolutions.backend.entities.User;

import java.util.concurrent.ThreadLocalRandom;


public class UserGenerator {

    private String[] firstNames = {
            "Olivia", "Liam", "Emma", "Noah", "Ava",
            "Elijah", "Sophia", "James", "Isabella", "Benjamin",
            "Mia", "Lucas", "Charlotte", "Mason", "Amelia",
            "Ethan", "Harper", "Logan", "Evelyn", "Jacob"
    };

    private String[] lastNames = {
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
        }
    }
}
