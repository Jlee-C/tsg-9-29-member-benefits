package com.yorksolutions.backend.repositories;

import com.yorksolutions.backend.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnrollmentRepository extends JpaRepository<Enrollment, UUID> {
    List<Enrollment> findByMember_Id(UUID memberId);
    List<Enrollment> findByPlan_Id(UUID planId);
}
