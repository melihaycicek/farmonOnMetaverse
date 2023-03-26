
package com.metaverse.farmon.security;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

<<<<<<< HEAD
import java.util.Collections;
=======
>>>>>>> 90b0314c6e9ade2837416d9bf4f014c9b907eebc
import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(@Value("${app.cors.allowed-origins}") List<String> allowedOrigins) {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
<<<<<<< HEAD
        config.setAllowedOriginPatterns(Collections.singletonList("*"));
=======
        config.setAllowedOriginPatterns(allowedOrigins);
>>>>>>> 90b0314c6e9ade2837416d9bf4f014c9b907eebc
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}