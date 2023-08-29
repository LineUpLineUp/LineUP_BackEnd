package com.linerup.lineup_backend.config;
/**
 * @author :
 * @version : 1.0.0
 * @package : com.linerup.lineup_backend.config
 * @name : SecurityConfig.java
 * @date : 2023/08/25 2:53 AM
 * @modified :
 **/

import com.linerup.lineup_backend.oauth2.converter.CustomRequestEntityConverter;
import com.linerup.lineup_backend.oauth2.repository.CustomAuthorizationRequestRepository;
import com.linerup.lineup_backend.oauth2.service.CustomOAuth2UserService;
import com.linerup.lineup_backend.oauth2.service.CustomOidcUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.JdbcOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JdbcTemplate jdbcTemplate;
    private final ClientRegistrationRepository clientRegistrationRepository;
    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomOidcUserService customOidcUserService;
    private final CustomAuthorizationRequestRepository customAuthorizationRequestRepository;


    @Bean
    public OAuth2AuthorizedClientService oAuth2AuthorizedClientService() {
        return new JdbcOAuth2AuthorizedClientService(jdbcTemplate, clientRegistrationRepository);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.oauth2Login()
                .authorizationEndpoint()
                .authorizationRequestRepository(customAuthorizationRequestRepository)
                .and()
                .authorizedClientService(oAuth2AuthorizedClientService())
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
                .oidcUserService(customOidcUserService);

        http.authorizeHttpRequests()
                .anyRequest().permitAll();
//      .anyRequest().authenticated();

        http.csrf().disable();

        return http.build();
    }

    @Bean
    public OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient() {
        DefaultAuthorizationCodeTokenResponseClient accessTokenResponseClient = new DefaultAuthorizationCodeTokenResponseClient();
        accessTokenResponseClient.setRequestEntityConverter(new CustomRequestEntityConverter());
        return accessTokenResponseClient;
    }
}
