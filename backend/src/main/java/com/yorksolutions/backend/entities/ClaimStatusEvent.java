package com.yorksolutions.backend.entities;

import com.yorksolutions.backend.entities.enums.ClaimStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaimStatusEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(optional = false)
    private Claim claim;

    @Enumerated(EnumType.STRING)
    private ClaimStatus status;

    private OffsetDateTime occurredAt;
}
