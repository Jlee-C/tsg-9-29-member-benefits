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
    @Column(nullable = false, length = 200)
    private String line1;
    @Column(length = 200)
    private String line2;
    @Column(nullable = false, length = 100)
    private String city;
    @Column(nullable = false, length = 50)
    private String state;
    @Column(nullable = false, length = 20)
    private String postalCode;

}
