package com.linerup.lineup_backend.oauth2.userinfo;

import java.util.Map;

/**
 * packageName    : com.linerup.lineup_backend.oauth2.userinfo
 * fileName       : NaverUserInfo
 * author         : moongi
 * date           : 12/13/23
 * description    :
 */
public class NaverUserInfo implements OAuth2UserInfo{

    private Map<String, Object> attributes;
    private Map<String, Object> attributeResponse;

    public NaverUserInfo(Map<String, Object> attributes) {
        this.attributes = (Map<String, Object>) attributes.get("response");
        this.attributeResponse = (Map<String, Object>) attributes.get("response");
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getProviderId() {
        return attributeResponse.get("id").toString();
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getEmail() {
        return attributeResponse.get("email").toString();
    }

    @Override
    public String getName() {
        return attributeResponse.get("name").toString();
    }
}
