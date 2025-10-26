package com.yorksolutions.backend.repositories;

import com.yorksolutions.backend.entities.ClaimLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClaimLineRepository extends JpaRepository<ClaimLine, UUID> {
}
