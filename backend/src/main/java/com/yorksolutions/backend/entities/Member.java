package com.yorksolutions.backend.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    private UUID id;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(name = "id", nullable = false)
    private User user;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    @Embedded
    private Address mailingAddress;
}
