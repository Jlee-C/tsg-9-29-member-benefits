package com.yorksolutions.backend.repositories;

import com.yorksolutions.backend.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProviderRepository extends JpaRepository<Provider, UUID> {
}
