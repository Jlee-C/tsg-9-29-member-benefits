package com.yorksolutions.backend.entities;

import com.yorksolutions.backend.entities.enums.ClaimStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String claimNumber;     // human-friendly key for UI

    @Column(name="member_id")
    private UUID memberID;

//    @ManyToOne(optional = false)
//    @JoinColumn(name="provider_id")
//    private Provider provider;      // FK: provider_id

    private LocalDate serviceStartDate;
    private LocalDate serviceEndDate;
    private LocalDate receivedDate;

    @Enumerated(EnumType.STRING)
    private ClaimStatus status;

    private BigDecimal totalBilled;
    private BigDecimal totalAllowed;
    private BigDecimal totalPlanPaid;
    private BigDecimal totalMemberResponsibility;

    @LastModifiedDate
    private OffsetDateTime updatedAt; // auto-updated by auditing
}
