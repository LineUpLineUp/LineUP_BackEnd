package com.linerup.lineup_backend.oauth2.userinfo;

import java.util.Map;

/**
 * packageName    : com.linerup.lineup_backend.oauth2.userinfo
 * fileName       : OAuth2UserInfo
 * author         : moongi
 * date           : 12/13/23
 * description    :
 */
public interface OAuth2UserInfo {

    Map<String, Object> getAttributes();

    String getProviderId();

    String getProvider();

    String getEmail();

    String getName();

}
