package com.linerup.lineup_backend.oauth2.userinfo;
/**
* @package : com.linerup.lineup_backend.oauth2.userinfo
* @name : CustomOAuth2UserInfo.java
* @date : 2023/08/25 2:51 AM
* @author : hyunwoopark
* @version : 1.0.0
* @modified :
**/

public interface CustomOAuth2UserInfo {
  String getProviderId();
  String getUserEmail();
  String getUserName();
}
