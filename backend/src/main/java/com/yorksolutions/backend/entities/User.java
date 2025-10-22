package com.yorksolutions.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;


@Entity // Makes a table with the Entity
@Table(name = "users")
@Data // Adds getters and setter, as well as overrides .toString and .equals
@NoArgsConstructor
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private UUID id;

   private String firstName;
   private String lastName;

   public User(String firstName, String lastName) {
       this.firstName = firstName;
       this.lastName = lastName;
   }

}