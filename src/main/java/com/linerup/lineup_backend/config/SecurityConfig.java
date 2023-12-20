package com.linerup.lineup_backend.config;

import com.linerup.lineup_backend.oauth2.PrincipalOAuth2UserService;
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

    private final PrincipalOAuth2UserService principalOAuth2UserService;
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
                .defaultSuccessUrl("/oauth/userInfo", true) // 로그인 성공시 이동할 URL
                .userInfoEndpoint()// 사용자가 로그인에 성공하였을 경우,
                .userService(principalOAuth2UserService); // 해당 서비스 로직을 타도록 설정


//                .and()
//                .csrf().disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.csrf().disable() // csrf 보안 설정 사용 X
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeHttpRequests() // 사용자가 보내는 요청에 인증 절차 수행 필요
                .requestMatchers(permitAllUrlPatterns).permitAll() // 해당 URL은 인증 절차 수행 생략 가능
                .anyRequest().authenticated(); // 나머지 요청들은 모두 인증 절차 수행해야함.

        return http.build();
    }
}
