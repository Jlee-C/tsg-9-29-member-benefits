package com.yorksolutions.backend.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.web.cors.CorsConfigurationSource;


@Slf4j
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,JwtDecoder jwtDecoder, CorsConfigurationSource corsConfigurationSource) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/api/**").authenticated()
                        .anyRequest().permitAll()
                )
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .csrf(AbstractHttpConfigurer::disable)
                .oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));

        return http.build();
    }

    // Keeping this code for reference
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
