package com.matteus.budgettracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Konfigurationsklass för att hantera CORS (Cross-Origin Resource Sharing).
 * CORS tillåter webbapplikationer att kommunicera med resurser på andra domäner.
 */
@Configuration
public class CorsConfig {

    /**
     * Skapar och returnerar en WebMvcConfigurer bean som konfigurerar CORS-inställningar.
     *
     * @return en WebMvcConfigurer med anpassade CORS-regler.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * Konfigurerar CORS-inställningar för att tillåta kommunikation från specifika ursprung.
             *
             * @param registry CORS-registret som hanterar inställningarna.
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Tillåter CORS för alla endpoint-mönster i applikationen.
                        .allowedOrigins("*") // Tillåter alla ursprung att kommunicera med servern.
                        .allowedMethods("GET", "POST", "PUT", "DELETE"); // Specificerar tillåtna HTTP-metoder.
            }
        };
    }
}
