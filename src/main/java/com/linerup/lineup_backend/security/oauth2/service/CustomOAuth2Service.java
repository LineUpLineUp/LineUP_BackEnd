package com.linerup.lineup_backend.security.oauth2.service;
/**
 * @author :
 * @version : 1.0.0
 * @package : com.linerup.lineup_backend.oauth2.service
 * @name : CustomOAuth2Service.java
 * @date : 2023/08/25 2:53 AM
 * @modified :
 **/

import com.linerup.lineup_backend.domain.member.Member;
import com.linerup.lineup_backend.security.oauth2.userinfo.CustomOAuth2UserInfo;
import com.linerup.lineup_backend.security.oauth2.userinfo.CustomOAuth2UserInfoFactory;
import com.linerup.lineup_backend.domain.OAuth2Provider;
import com.linerup.lineup_backend.domain.repository.UserRepository;

import java.util.Map;

public interface CustomOAuth2Service {

    default Member processUser(UserRepository userRepository, OAuth2Provider provider,
                               Map<String, Object> attributes) {
        System.out.println("attributes = " + attributes);
        CustomOAuth2UserInfo userInfo = CustomOAuth2UserInfoFactory.create(provider, attributes);
        String providerId = userInfo.getProviderId();
        String userName = userInfo.getUserName();
        String userEmail = userInfo.getUserEmail();
        System.out.println("userEmail = " + userEmail);
        System.out.println("userName = " + userName);
        return userRepository.findByProviderId(providerId)
                .orElseGet(() -> {
                    Member member = new Member(provider, providerId, userEmail, userName);
                    System.out.println("member = " + member);
                    return userRepository.save(member);
                });
    }

}
