package com.linerup.lineup_backend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : LineUP_BackEnd
 * @name : SecurityConfig
 * @date : 12/11/23 6:19 PM
 * @modifyed : $
 **/
@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        String[] permitAllUrlPatterns = {
                "/login/**", "/oauth2/**", "/auth/**",
                "/swagger-ui",
                "/swagger-ui/**",
                "/api-docs",
                "/api-docs/**",
                "/error"
        };
        http.oauth2Login()
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeHttpRequests()
                .requestMatchers(permitAllUrlPatterns).permitAll()
                .anyRequest().authenticated();

        return http.build();
    }
}
