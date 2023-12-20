package com.linerup.lineup_backend.oauth2.userinfo;


import java.util.Map;

/**
 * packageName    : com.linerup.lineup_backend.oauth2.userinfo
 * fileName       : KakaoUserInfo
 * author         : moongi
 * date           : 12/13/23
 * description    :
 */
public class KakaoUserInfo implements OAuth2UserInfo {

    private Map<String, Object> attributes;

    private Map<String, Object> attributeAccount;

    private Map<String, Object> attributeProfile;

    public KakaoUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
        this.attributeAccount = (Map<String, Object>) attributes.get("kakao_account");
        this.attributeProfile = (Map<String, Object>) attributeAccount.get("profile");
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getProviderId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getProvider() {
        return "Kakao";
    }

    @Override
    public String getEmail() {
        return attributeAccount.get("email").toString();
    }

    @Override
    public String getName() {
        return attributeProfile.get("nickname").toString();
    }
}
