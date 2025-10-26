package com.yorksolutions.backend.repositories;

import com.yorksolutions.backend.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProviderRepository extends JpaRepository<Provider, UUID> {
    List<Provider> findByNameContainingIgnoreCase(String name);
    List<Provider> findBySpecialtyContainingIgnoreCase(String specialty);
}
