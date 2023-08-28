package com.linerup.lineup_backend.oauth2.service;
/**
* @author :
* @version : 1.0.0
* @package : com.linerup.lineup_backend.oauth2.service
* @name : CustomOAuth2UserService.java
* @date : 2023/08/25 2:53 AM
* @modified :
**/
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.linerup.lineup_backend.domain.OAuth2Provider;
import com.linerup.lineup_backend.domain.Member;
import com.linerup.lineup_backend.domain.repository.UserRepository;
import com.linerup.lineup_backend.oauth2.user.CustomOAuth2User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class CustomOAuth2UserService extends DefaultOAuth2UserService implements
  CustomOAuth2Service {

  private final UserRepository userRepository;

  public CustomOAuth2UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    String registrationId = userRequest.getClientRegistration().getRegistrationId();
    log.info("registrationId = " + registrationId);

    Map<String, Object> attributes;
    OAuth2User oAuth2User = super.loadUser(userRequest);
    if(registrationId.contains("apple")){
      String idToken = userRequest.getAdditionalParameters().get("id_token").toString();
      attributes = decodeJwtPayload(idToken);
      attributes.put("id_token", idToken);
    }


    OAuth2Provider oAuth2Provider = OAuth2Provider.getProvider(userRequest);
    Member member = processUser(userRepository, oAuth2Provider, oAuth2User.getAttributes());
    return new CustomOAuth2User(member.getId(), member.getRole(), oAuth2User);
  }
  public Map<String, Object> decodeJwtPayload(String jwtToken){
    Map<String, Object> jwtClaims = new HashMap<>();
    try {
      String[] parts = jwtToken.split("\\.");
      Base64.Decoder decoder = Base64.getUrlDecoder();

      byte[] decodedBytes = decoder.decode(parts[1].getBytes(StandardCharsets.UTF_8));
      String decodedString = new String(decodedBytes, StandardCharsets.UTF_8);
      ObjectMapper mapper = new ObjectMapper();

      Map<String, Object> map = mapper.readValue(decodedString, Map.class);
      jwtClaims.putAll(map);

    } catch (JsonProcessingException e) {
      log.error("decodeJwtToken: {}-{} / jwtToken : {}", e.getMessage(), e.getCause(), jwtToken);
    }
    return jwtClaims;
  }


}
