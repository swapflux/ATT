package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import javax.crypto.spec.SecretKeySpec;

@Configuration
public class JwtConfig {

    private static final String SECRET = "swapnil-secret-key-project-1234567890";

    @Bean
    public JwtDecoder jwtDecoder() {

        return NimbusJwtDecoder.withSecretKey(
                new SecretKeySpec(
                        SECRET.getBytes(),
                        "HmacSHA256"
                )
        ).build();
    }
}