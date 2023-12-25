package com.linerup.lineup_backend.oauth2.userinfo;

import java.util.Map;

/**
 * packageName    : com.linerup.lineup_backend.oauth2.userinfo
 * fileName       : AppleOAuth2UserInfo
 * author         : moongi
 * date           : 12/20/23
 * description    :
 */
public class AppleUserInfo implements OAuth2UserInfo{

    private Map<String, Object> attributes;

    public AppleUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getProviderId() {
        return String.valueOf(attributes.get("sub"));
    }

    @Override
    public String getProvider() {
        return "apple";
    }

    @Override
    public String getEmail() {
        return attributes.get("email").toString();
    }

    @Override
    public String getName() {
        return attributes.get("name").toString();
    }
}
