package com.yorksolutions.backend.services;

import com.yorksolutions.backend.entities.Member;
import com.yorksolutions.backend.repositories.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class MemberService {


     private MemberRepository memberRepository;

     public Member generateMember(Member member) {
         member.setDateOfBirth(LocalDate.of(1980, 1, 1));
         return memberRepository.saveAndFlush(member);
     }
}
