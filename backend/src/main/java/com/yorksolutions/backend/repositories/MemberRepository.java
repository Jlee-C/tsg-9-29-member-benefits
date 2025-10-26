package com.yorksolutions.backend.repositories;

import com.yorksolutions.backend.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    Optional<Member> findByUser_Id(UUID userId);
}
