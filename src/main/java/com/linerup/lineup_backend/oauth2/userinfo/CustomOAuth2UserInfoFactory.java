package com.linerup.lineup_backend.oauth2.userinfo;
/**
* @author :
* @version : 1.0.0
* @package : com.linerup.lineup_backend.oauth2.userinfo
* @name : CustomOAuth2UserInfoFactory.java
* @date : 2023/08/25 2:53 AM
* @modified :
**/
import com.linerup.lineup_backend.domain.OAuth2Provider;
import java.util.Map;

public class CustomOAuth2UserInfoFactory {

  public static CustomOAuth2UserInfo create(OAuth2Provider provider,
                                            Map<String, Object> attributes) {
    return switch (provider) {
      case GITHUB -> new GithubOAuth2UserInfo(attributes);
      case GOOGLE -> new GoogleOAuth2UserInfo(attributes);
      case KAKAO -> new KakaoOAuth2UserInfo(attributes);
      case NAVER -> new NaverOAuth2UserInfo(attributes);
      case APPLE -> new AppleOAuth2UserInfo(attributes);
    };
  }
}
