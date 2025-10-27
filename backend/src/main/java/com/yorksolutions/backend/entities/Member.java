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
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, referencedColumnName = "id")
    private User user;

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

//    @Embedded
//    private Address mailingAddress;
}
