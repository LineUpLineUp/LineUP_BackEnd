package com.linerup.lineup_backend.oauth2.userinfo;
/**
* @author : 
* @version : 1.0.0
* @package : com.linerup.lineup_backend.oauth2.userinfo
* @name : GithubOAuth2UserInfo.java
* @date : 2023/08/25 4:41 AM
* @modified : 
**/
import java.util.Map;

public class GithubOAuth2UserInfo implements CustomOAuth2UserInfo {

  private final Map<String, Object> attributes;

  public GithubOAuth2UserInfo(Map<String, Object> attributes) {
    this.attributes = attributes;
  }

  @Override
  public String getProviderId() {
    return String.valueOf(attributes.get("id"));
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
