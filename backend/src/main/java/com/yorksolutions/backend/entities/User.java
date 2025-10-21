package com.yorksolutions.backend.entities;

import lombok.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
public class User {
   @Id
   private UUID id;

   private String authProvider;     // e.g., "google", "okta"

   private String authSub;          // OIDC subject ("sub"), unique per provider

   private String email;            // from ID token

   private OffsetDateTime createdAt;

   private OffsetDateTime updatedAt;
}