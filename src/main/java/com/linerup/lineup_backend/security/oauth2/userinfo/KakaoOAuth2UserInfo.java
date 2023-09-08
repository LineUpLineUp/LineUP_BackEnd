package com.linerup.lineup_backend.security.oauth2.userinfo;
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
    private Map<String, Object> kakaoAccount;

    public KakaoOAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
        this.kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
    }

    @Override
    public String getProviderId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getUserEmail() {
        return (String) kakaoAccount.get("email");
    }

    @Override
    public String getUserName() {
        Map<String, String> profile = (Map<String, String>) kakaoAccount.get("profile");
        return profile.get("nickname");
    }
}
