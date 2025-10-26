package com.yorksolutions.backend.repositories;

import com.yorksolutions.backend.entities.Accumulator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface AccumulatorRepository extends JpaRepository<Accumulator, UUID> {
    List<Accumulator> findByEnrollment_Id(UUID enrollmentId);
}
