package com.yorksolutions.backend.repositories;

import com.yorksolutions.backend.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlanRepository extends JpaRepository<Plan, UUID> {
}
