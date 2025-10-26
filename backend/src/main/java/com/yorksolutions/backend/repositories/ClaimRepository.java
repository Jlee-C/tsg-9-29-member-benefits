package com.yorksolutions.backend.repositories;

import com.yorksolutions.backend.entities.Claim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClaimRepository extends JpaRepository<Claim, UUID> {
}
