package com.yorksolutions.backend.repositories;

import com.yorksolutions.backend.entities.Plan;
import com.yorksolutions.backend.entities.enums.PlanType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PlanRepository extends JpaRepository<Plan, UUID> {
    List<Plan> findByPlanYear(Integer planYear);
    List<Plan> findByType(PlanType type);
}
