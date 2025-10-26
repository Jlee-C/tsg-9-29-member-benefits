package com.yorksolutions.backend.entities;

import com.yorksolutions.backend.entities.enums.AccumulatorType;
import com.yorksolutions.backend.entities.enums.NetworkTier;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Accumulator {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Enrollment enrollment;

    @Enumerated(EnumType.STRING)
    private AccumulatorType type;

    @Enumerated(EnumType.STRING)
    private NetworkTier tier;

    private BigDecimal limitAmount;
    private BigDecimal usedAmount;
}