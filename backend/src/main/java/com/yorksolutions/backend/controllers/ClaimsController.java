package com.yorksolutions.backend.controllers;

import com.yorksolutions.backend.entities.Claim;
import com.yorksolutions.backend.entities.Member;
import com.yorksolutions.backend.repositories.ClaimRepository;
import com.yorksolutions.backend.repositories.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
@AllArgsConstructor
public class ClaimsController {
    ClaimRepository claimsRepository;
    MemberRepository memberRepository;

    @GetMapping("/{sub}")
    public ResponseEntity<List<Claim>> getClaims(@PathVariable String sub) {
        try {
            Member member = memberRepository.findByUser_authSub(sub).get();
            return ResponseEntity.ok().body(claimsRepository.findByMemberId(member.getId()));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
