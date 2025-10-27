package com.yorksolutions.backend.services;

import com.yorksolutions.backend.entities.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DataSeeder {

    private MemberService memberService;
    private ClaimsGenerator claimsGenerator;

    public void generateData(Member member) {
        Member m = memberService.generateMember(member);
        for (int i = 0; i < 9; i++) {
            claimsGenerator.generateClaim(m);
        }
    }

}
