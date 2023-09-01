package com.linerup.lineup_backend.security.oauth2.userinfo;
/**
 * @author :
 * @version : 1.0.0
 * @package : com.linerup.lineup_backend.oauth2.userinfo
 * @name : GoogleOAuth2UserInfo.java
 * @date : 2023/08/25 4:44 AM
 * @modified :
 **/

import java.util.Map;

public class GoogleOAuth2UserInfo implements CustomOAuth2UserInfo {

    private final Map<String, Object> attributes;

    public GoogleOAuth2UserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String getProviderId() {
        return attributes.get("sub").toString();
    }

    @Override
    public String getUserEmail() {
        return (String) attributes.get("email");
    }

    @Override
    public String getUserName() {
        return (String) attributes.get("name");
    }
}
