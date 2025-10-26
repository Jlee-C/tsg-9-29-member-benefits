package com.yorksolutions.backend.entities;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.OffsetDateTime;
import java.util.UUID;

 @Entity
 @Table(name = "users")
 @EntityListeners((AuditingEntityListener.class))
 @Getter @Setter
@NoArgsConstructor
public class User {

     @Id
     @GeneratedValue(strategy = GenerationType.UUID)
     private UUID id;

     @Column(nullable = false)
    private String authProvider;

     @Column(nullable = false)
    private String authSub;

     @Column(nullable = false)
    private String email;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime updatedAt;

    @Builder
    public User(String authProvider, String authSub, String email) {
        this.authProvider = authProvider;
        this.authSub = authSub;
        this.email = email;
    }
}
