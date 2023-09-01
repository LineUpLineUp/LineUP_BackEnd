package com.linerup.lineup_backend.config;
/**
 * @author :
 * @version : 1.0.0
 * @package : com.linerup.lineup_backend.config
 * @name : SecurityConfig.java
 * @date : 2023/08/25 2:53 AM
 * @modified :
 **/

import com.linerup.lineup_backend.security.oauth2.repository.CustomAuthorizationRequestRepository;
import com.linerup.lineup_backend.security.oauth2.service.CustomOAuth2UserService;
import com.linerup.lineup_backend.security.oauth2.service.CustomOidcUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomOidcUserService customOidcUserService;
    private final CustomAuthorizationRequestRepository customAuthorizationRequestRepository;
    private final OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.oauth2Login()

                .tokenEndpoint().accessTokenResponseClient(accessTokenResponseClient)
                .and()
                .authorizationEndpoint().authorizationRequestRepository(customAuthorizationRequestRepository)
                .and()
                .userInfoEndpoint()
                .userService(customOAuth2UserService)
                .oidcUserService(customOidcUserService);

        http.authorizeHttpRequests()
                .anyRequest().authenticated();

        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

//    @Bean
//    public DefaultOAuth2AuthorizationRequestResolver defaultOAuth2AuthorizationRequestResolver(){
//        return new DefaultOAuth2AuthorizationRequestResolver(oAuth2AuthorizedClientService(),)
//    }
}

