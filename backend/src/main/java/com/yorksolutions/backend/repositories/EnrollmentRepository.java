package com.yorksolutions.backend.repositories;

import com.yorksolutions.backend.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnrollmentRepository extends JpaRepository<Enrollment, UUID> {
}
