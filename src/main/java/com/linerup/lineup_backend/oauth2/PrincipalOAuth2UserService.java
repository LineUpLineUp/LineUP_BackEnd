package com.linerup.lineup_backend.oauth2;

import com.linerup.lineup_backend.entity.member.Member;
import com.linerup.lineup_backend.entity.member.Role;
import com.linerup.lineup_backend.oauth2.userinfo.GoogleUserInfo;
import com.linerup.lineup_backend.oauth2.userinfo.KakaoUserInfo;
import com.linerup.lineup_backend.oauth2.userinfo.NaverUserInfo;
import com.linerup.lineup_backend.oauth2.userinfo.OAuth2UserInfo;
import com.linerup.lineup_backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * packageName    : com.linerup.lineup_backend.oauth2
 * fileName       : PrincipalOAuth2UserService
 * author         : moongi
 * date           : 12/13/23
 * description    :
 */
@Service
public class PrincipalOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String tokenValue = userRequest.getAccessToken().getTokenValue();
        System.out.println("tokenValue = " + tokenValue);

        OAuth2UserInfo oAuth2UserInfo = null;
        String provider = userRequest.getClientRegistration().getRegistrationId();

        if (provider.equals("google")) {
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if (provider.equals("naver")) {
            oAuth2UserInfo = new NaverUserInfo(oAuth2User.getAttributes());
        } else if (provider.equals("kakao")) {
            oAuth2UserInfo = new KakaoUserInfo(oAuth2User.getAttributes());
        }
        // TODO: apple login

        String providerId = oAuth2UserInfo.getProviderId();
        String email = oAuth2UserInfo.getEmail();
        String name = oAuth2UserInfo.getName();
        Role role = Role.USER;

        Member byProviderId = memberRepository.findByProviderId(providerId);

        if (byProviderId == null) {
            byProviderId = Member.oauth2Register()
                    .role(role).provider(provider).providerId(providerId)
                    .email(email).name(name)
                            .createdDate(LocalDateTime.now())
                    .build();
            memberRepository.save(byProviderId);
        }
        return new PrincipalDetails(byProviderId, oAuth2UserInfo);
    }
}
