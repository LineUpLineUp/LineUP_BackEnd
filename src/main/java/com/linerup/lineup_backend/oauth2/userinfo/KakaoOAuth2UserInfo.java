package com.linerup.lineup_backend.oauth2.userinfo;
/**
* @author : 
* @version : 1.0.0
* @package : com.linerup.lineup_backend.oauth2.userinfo
* @name : KakaoOAuth2UserInfo.java
* @date : 2023/08/25 4:38 AM
* @modified : 
**/
import java.util.Map;

public class KakaoOAuth2UserInfo implements CustomOAuth2UserInfo {

  private final Map<String, Object> attributes;

  public KakaoOAuth2UserInfo(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  @Override
  public String getProviderId() {
    return attributes.get("id").toString();
  }

  @Override
  public String getUserEmail() {
    return null;
  }

  @Override
  public String getUserName() {
    return null;
  }
}
