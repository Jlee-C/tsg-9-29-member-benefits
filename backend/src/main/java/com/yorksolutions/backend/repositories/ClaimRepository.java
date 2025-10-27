package com.yorksolutions.backend.repositories;

import com.yorksolutions.backend.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClaimRepository extends JpaRepository<Claim, UUID> {
//    List<Claim> findByProvider_Id(UUID providerId);
      Optional<Claim> findByClaimNumber(String claimNumber);
      List<Claim> findByMemberId(UUID memberId);
}
