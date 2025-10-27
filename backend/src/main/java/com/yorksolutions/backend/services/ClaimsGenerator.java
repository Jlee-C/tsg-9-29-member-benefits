package com.yorksolutions.backend.services;

import com.yorksolutions.backend.entities.Claim;
import com.yorksolutions.backend.entities.Member;
import com.yorksolutions.backend.entities.Provider;
import com.yorksolutions.backend.entities.enums.ClaimStatus;
import com.yorksolutions.backend.repositories.ClaimRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ClaimsGenerator {

    private final ClaimRepository claimRepository;

    public ClaimsGenerator(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    public int randomNumber(int min, int max){
        return ThreadLocalRandom.current().nextInt(0, (max));
    }

    private LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }


    public Claim generateClaim(Member member) {
        LocalDate date = between(member.getDateOfBirth().plusDays(6570), LocalDate.now().minusDays(1));
        Claim claim = Claim.builder()
                .claimNumber("c-"+randomNumber(1,999))
                .memberID(member.getId())
                .serviceStartDate(date)
                .serviceEndDate(date.plusDays(randomNumber(1,365)))
                .receivedDate(date.minusDays(randomNumber(1,10)))
                .status(ClaimStatus.PROCESSED)
                .totalBilled(new BigDecimal(150))
                .totalAllowed(new BigDecimal(50))
                .totalPlanPaid(new BigDecimal(20))
                .totalMemberResponsibility(new BigDecimal(50))
                .build();
        claimRepository.save(claim);
        return claim;
    }
}
