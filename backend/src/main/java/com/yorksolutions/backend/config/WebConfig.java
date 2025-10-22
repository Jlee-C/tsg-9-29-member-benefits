package com.yorksolutions.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/// Allows two localhost origins to "talk" to each other without getting blocked by cors protocol
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override // implicitly addeed to securityFilterChain with spring context
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:5137")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }
}
