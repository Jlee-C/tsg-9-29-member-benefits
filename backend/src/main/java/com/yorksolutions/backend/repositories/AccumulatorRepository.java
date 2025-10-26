package com.yorksolutions.backend.repositories;

import com.yorksolutions.backend.entities.Accumulator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface AccumulatorRepository extends JpaRepository<Accumulator, UUID> {
}
