package com.linerup.lineup_backend.security.oauth2.userinfo;

import java.util.Map;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : LineUP_BackEnd
 * @name : NaverOAuth2UserInfo
 * @date : 2023/08/26 12:33 AM
 * @modifyed : $
 **/
public class NaverOAuth2UserInfo implements CustomOAuth2UserInfo{

    private final Map<String, Object> attributes;
    private Map<String, Object> attributesResponse;

    public NaverOAuth2UserInfo(Map<String, Object> attributes) {

        this.attributes = attributes;
        this.attributesResponse = (Map<String, Object>)attributes.get("response");
    }

    @Override
    public String getProviderId() {
        return attributesResponse.get("id").toString();
    }

    @Override
    public String getUserEmail() {
        return attributesResponse.get("email").toString();
    }
    @Override
    public String getUserName() {
        return attributesResponse.get("name").toString();
    }
}
