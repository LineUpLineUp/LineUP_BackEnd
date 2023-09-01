package com.linerup.lineup_backend.domain;
/**
* @author :
* @version : 1.0.0
* @package : com.linerup.lineup_backend.domain
* @name : OAuth2Provider.java
* @date : 2023/08/25 2:53 AM
* @modified :
**/
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;

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
