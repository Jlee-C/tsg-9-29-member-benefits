package com.yorksolutions.backend.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.jwt.*;



@Slf4j
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtDecoder jwtDecoder) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/api/**").authenticated()
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));

        return http.build();
    }

    // just realized spring does this for you
//    @Bean
//    protected JwtDecoder jwtDecoder() {
//        NimbusJwtDecoder decoder = NimbusJwtDecoders.fromOidcIssuerLocation("https://accounts.google.com");
//
//        OAuth2TokenValidator<Jwt> validator =
//                new DelegatingOAuth2TokenValidator<>(
//                        new JwtTimestampValidator(),
//                        new JwtIssuerValidator("https://accounts.google.com"),
//                        new JwtAudienceValidator(googleClientId)
//                );
//        decoder.setJwtValidator(validator);
//        return decoder;
//    }

}
