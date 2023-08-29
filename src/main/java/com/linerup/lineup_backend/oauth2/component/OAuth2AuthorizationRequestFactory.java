package com.linerup.lineup_backend.oauth2.component;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : LineUP_BackEnd
 * @name : OAuth2AuthorizationRequestFactory
 * @date : 2023/08/29 6:47 PM
 * @modifyed : $
 **/
@Component
public class OAuth2AuthorizationRequestFactory {
    public OAuth2AuthorizationRequest makeOAuth2AuthorizationRequest(HttpServletRequest request) {
        if (request.getRequestURI().contains("naver"))
            return ofNaver(request);
        return null;
    }

    private final OAuth2AuthorizationRequest naverTemplate = OAuth2AuthorizationRequest
            .authorizationCode()
            .authorizationUri("https://nid.naver.com/oauth2.0/authorize")
            .clientId("B_92M4CV3XEimJYDRlDj")
            .redirectUri("https://test.hyunwoo.tech/login/oauth2/code/naver")
            .authorizationRequestUri("https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=B_92M4CV3XEimJYDRlDj&scope=name%20email&state=y74dsHxN5-PzL_XmJFPnYzYk9uReU5CyNUvsSz8uiM0%3D&redirect_uri=https://test.hyunwoo.tech/login/oauth2/code/naver")
            .attributes(attributes -> {
                attributes.put("registration_id", "naver");
            })
            .build();

    private OAuth2AuthorizationRequest ofNaver(HttpServletRequest request) {
        Set<String> scopes = new HashSet<>();
        scopes.add("name");
        scopes.add("email");
        return OAuth2AuthorizationRequest
                .from(naverTemplate)
                .scopes(scopes)
                .state(request.getParameter("state"))
                .build();
    }
}
