package com.yorksolutions.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;


@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Column(nullable = true, length = 200)
    private String line1;
    @Column(length = 200)
    private String line2;
    @Column(nullable = true, length = 100)
    private String city;
    @Column(nullable = true, length = 50)
    private String state;
    @Column(nullable = true, length = 20)
    private String postalCode;

}
