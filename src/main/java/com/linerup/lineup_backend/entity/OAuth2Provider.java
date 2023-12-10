package com.linerup.lineup_backend.entity;

import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;

/**
 * packageName    : com.linerup.lineup_backend.entity
 * fileName       : OAuth2Provider
 * author         : moongi
 * date           : 12/10/23
 * description    :
 */
public enum OAuth2Provider {
    GOOGLE,
    KAKAO,
    NAVER,
    APPLE;

    public static OAuth2Provider getProvider(OAuth2UserRequest oAuth2UserRequest) {
        String registrationId = oAuth2UserRequest.getClientRegistration().getRegistrationId();
        return OAuth2Provider.valueOf(registrationId.toUpperCase());
    }
}
