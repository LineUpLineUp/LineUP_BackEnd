package com.linerup.lineup_backend.security.oauth2.service;
/**
* @author : 
* @version : 1.0.0
* @package : com.linerup.lineup_backend.oauth2.service
* @name : CustomOidcUserService.java
* @date : 2023/08/25 3:59 AM
* @modified : 
**/
import com.linerup.lineup_backend.domain.member.Member;
import com.linerup.lineup_backend.security.oauth2.user.CustomOidcUser;
import com.linerup.lineup_backend.domain.OAuth2Provider;
import com.linerup.lineup_backend.domain.repository.UserRepository;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;

@Component
public class CustomOidcUserService extends OidcUserService implements CustomOAuth2Service {

  private final UserRepository userRepository;

  public CustomOidcUserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
    OidcUser oidcUser = super.loadUser(userRequest);
    OAuth2Provider oAuth2Provider = OAuth2Provider.getProvider(userRequest);
    Member member = processUser(userRepository, oAuth2Provider, oidcUser.getAttributes());
    return new CustomOidcUser(member.getId(), member.getRole(), oidcUser);
  }
}
