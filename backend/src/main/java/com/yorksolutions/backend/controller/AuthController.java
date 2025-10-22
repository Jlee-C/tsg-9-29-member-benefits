package com.yorksolutions.backend.controller;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/api/auth/me")
    public Object geUser(@AuthenticationPrincipal OidcUser oidcUser) {
        if (oidcUser == null) {
            return ResponseEntity.notFound().build();
        }
        return  new UserInfo(
                oidcUser.getFullName(),
                oidcUser.getEmail(),
                oidcUser.getPicture()
        );
    }

    record UserInfo(String name, String email, String picture) {}
}

